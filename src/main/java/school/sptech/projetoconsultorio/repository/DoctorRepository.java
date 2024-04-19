package school.sptech.projetoconsultorio.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import school.sptech.projetoconsultorio.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
