package school.sptech.projetoconsultorio.dto.appointment;

import lombok.Getter;
import lombok.Setter;
import school.sptech.projetoconsultorio.entity.Doctor;

import java.time.LocalDate;

@Getter
@Setter
public class AppointmentResponse {
    private int id;
    private String name;
    private LocalDate dateScheduled;
    private double price;
    private String location;
    private Doctor doctor;
}
