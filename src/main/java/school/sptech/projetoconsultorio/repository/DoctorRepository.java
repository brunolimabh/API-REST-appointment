package school.sptech.projetoconsultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.projetoconsultorio.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
