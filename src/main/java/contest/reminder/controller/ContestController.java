package contest.reminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import contest.reminder.entities.CodeChefAPIResponse;
import contest.reminder.services.ContestService;

@RestController
@RequestMapping("/contest")
public class ContestController {

	@Autowired
	private ContestService contestService;
	
	@GetMapping("/getAll")
	public CodeChefAPIResponse getAll(
			@RequestParam("authorizationCode") String authorizationCode) {
		return contestService.getAll(authorizationCode);
	}
}
