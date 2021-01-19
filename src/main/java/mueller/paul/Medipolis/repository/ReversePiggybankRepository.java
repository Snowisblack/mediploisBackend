package mueller.paul.Medipolis.repository;

import mueller.paul.Medipolis.model.ReversePiggybank;
import mueller.paul.Medipolis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReversePiggybankRepository extends JpaRepository<ReversePiggybank, Long> {
    ReversePiggybank findByUser(User user);
}
