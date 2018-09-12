package contest.reminder.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import contest.reminder.entities.CodeChefAPIResponse;
import contest.reminder.entities.CodechefOAuthDetails;
import contest.reminder.enums.CodeChefAPIResponseStatus;
import contest.reminder.spring.OAuthStorage;

@Service
public class CodechefAPIService {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private OAuthStorage oAuthStorage;

	private final String PREFIX_URL = "https://api.codechef.com";
	
	public CodeChefAPIResponse processGET(
			String accessToken, String uri) {
		String url = getUrl(uri);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Authorization", "Bearer " + accessToken);
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		return restTemplate.exchange(url, HttpMethod.GET, 
				entity, CodeChefAPIResponse.class).getBody();
	}
	
	public CodeChefAPIResponse processGETRequest(
			String authorizationCode, String uri) {
		CodeChefAPIResponse response = new CodeChefAPIResponse();
		if(authorizationCode == null || authorizationCode.isEmpty()) {
			response.setStatus(
					CodeChefAPIResponseStatus.NO_AUTHORIZATION
					.getMessage());
			return response;
		}
		
		CodechefOAuthDetails details = new CodechefOAuthDetails();
		details.setgrant_type("authorization_code");
		details.setCode(authorizationCode);
		details.setclient_id(oAuthStorage.getClientId());
		details.setclient_secret(oAuthStorage.getClientSecret());
		details.setredirect_uri(oAuthStorage.getRedirectURI());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		HttpEntity<CodechefOAuthDetails> request = 
				new HttpEntity<CodechefOAuthDetails>(details, headers);
		String url = oAuthStorage.getAuthURL();
		CodeChefAPIResponse oAuthResponse = 
				restTemplate.postForEntity(url, request, CodeChefAPIResponse.class)
				.getBody();
		String accessToken = oAuthResponse.getResult().getData().getAccess_token();
		String refreshToken = oAuthResponse.getResult().getData().getRefresh_token();
		Map<String, Map<String, String>> map = oAuthStorage.getTokensToAuthCodeMap();
		Map<String, String> subMap = new HashMap<>();
		subMap.put("accessToken", accessToken);
		subMap.put("refreshToken", refreshToken);
		map.put(authorizationCode, subMap);
		oAuthStorage.setTokensToAuthCodeMap(map);
		
		url = getUrl(uri);
		headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Authorization", "Bearer " + accessToken);
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		return restTemplate.exchange(url, HttpMethod.GET, 
				entity, CodeChefAPIResponse.class).getBody();
	}
	
	private String getUrl(String uri) {
		return PREFIX_URL + uri;
	}
	
}
