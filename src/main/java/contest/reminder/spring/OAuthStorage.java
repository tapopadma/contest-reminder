package contest.reminder.spring;

import java.util.HashMap;
import java.util.Map;

public class OAuthStorage {

	private final String CLIENT_ID = "a9608cd52c8ffd08c2fea303e13090c0";
	private final String CLIENT_SECRET = "95e9e52745e0f73a2b6f7e3187208c78";
	private final String REDIRECT_URI = "http://localhost:8080";
	private final String AUTH_SERVER_URL = "https://api.codechef.com/oauth/token"; 

	/**
	 * The key is a authorizationCode unique to each user
	 * The value is map with 2 keys : accessToken, refreshToken 
	 */
	Map<String, Map<String, String>> tokensToAuthCodeMap;
	
	public Map<String, Map<String, String>> getTokensToAuthCodeMap() {
		return tokensToAuthCodeMap;
	}

	public void setTokensToAuthCodeMap(Map<String, Map<String, String>> tokensToAuthCodeMap) {
		this.tokensToAuthCodeMap = tokensToAuthCodeMap;
	}

	public String getClientId() {
		return CLIENT_ID;
	}
	
	public String getClientSecret() {
		return CLIENT_SECRET;
	}
	
	public String getRedirectURI() {
		return REDIRECT_URI;
	}

	public String getAuthURL(){
		return AUTH_SERVER_URL;
	}
	
	public OAuthStorage() {
		tokensToAuthCodeMap = new HashMap<>();
	}
	
}
