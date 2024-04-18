package school.sptech.projetoconsultorio.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ConsultaRequest {
    private String nome;
    private LocalDate dataAgendamento;
    private double preco;
    private String local;
}
