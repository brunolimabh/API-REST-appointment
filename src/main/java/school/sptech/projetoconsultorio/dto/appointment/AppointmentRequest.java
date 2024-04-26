package school.sptech.projetoconsultorio.dto.appointment;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentRequest {
    private String name;
    private LocalDate dateScheduled;
    private double price;
    private String location;
    private int doctorId;
}
