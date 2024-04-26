package school.sptech.projetoconsultorio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String crm;
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
}
