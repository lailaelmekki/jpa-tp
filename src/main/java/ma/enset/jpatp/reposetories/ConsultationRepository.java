package ma.enset.jpatp.reposetories;

import ma.enset.jpatp.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
