package school.sptech.projetoconsultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import school.sptech.projetoconsultorio.entity.Consulta;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

//    @Query("SELECT c FROM Consulta c WHERE c.medico.id = :id")
    List<Consulta> findByMedicoId(int medicoId);

    @Query("SELECT COALESCE(AVG(c.preco), 0) FROM Consulta c")
    double avgConsultPrice();

    @Query("SELECT COALESCE(SUM(c.preco), 0) FROM Consulta c WHERE c.medico.id = :medicoId")
    double sumConsultPriceByMedico(int medicoId);
}
