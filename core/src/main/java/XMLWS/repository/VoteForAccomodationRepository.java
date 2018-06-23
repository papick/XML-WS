package XMLWS.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import XMLWS.model.Accommodation;
import XMLWS.model.VoteForAccomdoation;

@Repository
public interface VoteForAccomodationRepository extends JpaRepository<VoteForAccomdoation, Long> {
	
	ArrayList<VoteForAccomdoation> findAllByAccomodation(Accommodation acc);
}
