package contest.reminder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contest.reminder.entities.CodeChefAPIResponse;

@Service
public class ContestService {

	@Autowired
	private CodechefAPIService codechefAPIService;
	
	public CodeChefAPIResponse getAll(String authorizationCode) {
		return codechefAPIService.processGETRequest(authorizationCode, "/contests");
	}
	
}
