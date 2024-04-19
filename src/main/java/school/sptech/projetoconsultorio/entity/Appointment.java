package school.sptech.projetoconsultorio.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate dateScheduled;
    private double price;
    private String location;
    @ManyToOne
    private Doctor doctor;
}
