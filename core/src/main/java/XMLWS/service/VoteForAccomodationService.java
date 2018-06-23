package XMLWS.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XMLWS.dto.VoteDTO;
import XMLWS.model.Accommodation;
import XMLWS.model.User;
import XMLWS.model.VoteForAccomdoation;
import XMLWS.repository.AccomodationRepository;
import XMLWS.repository.UserRepository;
import XMLWS.repository.VoteForAccomodationRepository;

@Service
public class VoteForAccomodationService {

	@Autowired
	private VoteForAccomodationRepository voteRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccomodationRepository accomodationRepository;

	public void vote(VoteDTO voteDTO) {

		VoteForAccomdoation vote = new VoteForAccomdoation();
		vote.setVote(voteDTO.getVote());
		User user = userRepository.findByUsername(voteDTO.getUsername());
		vote.setUser(user);
		Accommodation acc = accomodationRepository.findOne(Long.parseLong(voteDTO.getIdAccomodation()));
		vote.setAccomodation(acc);

		voteRepository.save(vote);
	}

	public VoteForAccomdoation getVote(Long idAcc, String username) {
		VoteForAccomdoation vote;
		Accommodation acc = accomodationRepository.findOne(idAcc);
		ArrayList<VoteForAccomdoation> votes = voteRepository.findAllByAccomodation(acc);
		for (int i = 0; i < votes.size(); i++) {
			if (votes.get(i).getUser().equals(userRepository.findByUsername(username))) {
				vote = votes.get(i);
				return vote;
			}
		}
		return null;
	}
}
