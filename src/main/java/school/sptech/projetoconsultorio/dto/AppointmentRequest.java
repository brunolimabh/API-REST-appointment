package school.sptech.projetoconsultorio.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AppointmentRequest {
    private String name;
    private LocalDate dateScheduled;
    private double price;
    private String location;
    private int doctorId;
}
