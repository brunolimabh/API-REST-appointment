package school.sptech.projetoconsultorio.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private LocalDate dataAgendamento;
    private double preco;
    private String local;
    @ManyToOne
    private Medico medico;
}
