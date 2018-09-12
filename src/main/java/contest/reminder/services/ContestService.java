package contest.reminder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contest.reminder.entities.CodeChefAPIResponse;

@Service
public class ContestService {

	@Autowired
	private CodechefAPIService codechefAPIService;
	
	public CodeChefAPIResponse getAll(String accessToken,
			String offset, String limit) {
		return codechefAPIService.processGET(accessToken, 
				"/contests?offset="+offset+
				"&limit="+limit);
	}
	
}
