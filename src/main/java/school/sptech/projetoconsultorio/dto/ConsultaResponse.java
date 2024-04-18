package school.sptech.projetoconsultorio.dto;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import school.sptech.projetoconsultorio.entity.Medico;

import java.time.LocalDate;

@Getter
@Setter
public class ConsultaResponse {
    private int id;
    private String nome;
    private LocalDate dataAgendamento;
    private double preco;
    private String local;
    private Medico medico;
}
