package mueller.paul.Medipolis;

import mueller.paul.Medipolis.model.Penalty;
import mueller.paul.Medipolis.repository.PenaltyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhrasenschweinApplication {

	/*
	In der Apllication.properties können die Eintsellungen für die Datenbank getroffen werden.
	In test/mueller.paul.Medipolis ist eine Testklasse, in der DummyDaten bereit stehen.
	 */
	public static void main(String[] args) {
		SpringApplication.run(PhrasenschweinApplication.class, args);
	}

}
