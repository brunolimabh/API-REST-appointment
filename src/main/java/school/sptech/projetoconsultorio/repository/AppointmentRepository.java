package school.sptech.projetoconsultorio.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import school.sptech.projetoconsultorio.entity.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findByDoctorId(int doctorId);

    @Query("SELECT COALESCE(AVG(a.price), 0) FROM Appointment a")
    double avgPrice();

    @Query("SELECT COALESCE(SUM(a.price), 0) FROM Appointment a WHERE a.doctor.id = :doctorId")
    double sumPriceByDoctor(int doctorId);

    List<Appointment> findByDoctorIdAndDateScheduledBetween(int doctorId, LocalDate dateInicial, LocalDate dateFinal);

    @Transactional
    @Modifying
    @Query("UPDATE Appointment a SET a.name = :name WHERE a.id = :id")
    void updateName(int id, String name);

    @Transactional
    @Modifying
    @Query("DELETE FROM Appointment a WHERE a.doctor.id = :id")
    void removeByDoctor(int id);
}
