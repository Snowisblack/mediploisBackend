package mueller.paul.Medipolis;

import mueller.paul.Medipolis.model.Penalty;
import mueller.paul.Medipolis.model.ReversePiggybank;
import mueller.paul.Medipolis.model.User;
import mueller.paul.Medipolis.repository.PenaltyRepository;
import mueller.paul.Medipolis.repository.ReversePiggybankRepository;
import mueller.paul.Medipolis.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PhrasenschweinApplicationTests {

	@Autowired
	private PenaltyRepository penaltyRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ReversePiggybankRepository reversePiggybankRepository;

	@Test
	void contextLoads() {

	}

	@Test
	void LoadPenalties(){
		Penalty penalty = new Penalty("Standardstrafe", 1f);
		penaltyRepository.save(penalty);
		penalty = new Penalty("Standardstrafe2", 2f);
		penaltyRepository.save(penalty);
		penalty = new Penalty("Standardstrafe3", 1.5f);
		penaltyRepository.save(penalty);
		penalty = new Penalty("Standardstrafe4", 4.5f);
		penaltyRepository.save(penalty);
	}

	@Test
	void LoadUser(){
		User user = new User("Max Mustermann", "test");
		ReversePiggybank piggybank = new ReversePiggybank();
		user.setReversePiggybank(piggybank);
		reversePiggybankRepository.save(piggybank);
		userRepository.save(user);
		piggybank.setUser(user);
		reversePiggybankRepository.save(piggybank);
		user = new User("Linda Lindemann", "test");
		piggybank = new ReversePiggybank();
		user.setReversePiggybank(piggybank);
		reversePiggybankRepository.save(piggybank);
		userRepository.save(user);
		piggybank.setUser(user);
		reversePiggybankRepository.save(piggybank);
		user = new User("Moritz Müller", "test");
		piggybank = new ReversePiggybank();
		user.setReversePiggybank(piggybank);
		reversePiggybankRepository.save(piggybank);
		userRepository.save(user);
		piggybank.setUser(user);
		reversePiggybankRepository.save(piggybank);
		user = new User("Renate Richter", "test");
		piggybank = new ReversePiggybank();
		user.setReversePiggybank(piggybank);
		reversePiggybankRepository.save(piggybank);
		userRepository.save(user);
		piggybank.setUser(user);
		reversePiggybankRepository.save(piggybank);
	}

}
