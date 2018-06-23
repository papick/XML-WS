package XMLWS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import XMLWS.dto.VoteDTO;
import XMLWS.model.VoteForAccomdoation;
import XMLWS.service.VoteForAccomodationService;

@RestController
@RequestMapping(value = "/api/vote")
public class VoteForAccomodationController {

	@Autowired
	private VoteForAccomodationService voteService;

	@PostMapping("/new-vote")
	public void vote(@RequestBody VoteDTO voteDTO) {

		voteService.vote(voteDTO);

	}
	
	@GetMapping("/get-vote/{idAcc}/{username}")
	public ResponseEntity<VoteForAccomdoation> vote(@PathVariable Long idAcc , @PathVariable String username) {

		VoteForAccomdoation vote=voteService.getVote(idAcc,username);
		
		return new ResponseEntity<VoteForAccomdoation>(vote, HttpStatus.OK);

	}
}
