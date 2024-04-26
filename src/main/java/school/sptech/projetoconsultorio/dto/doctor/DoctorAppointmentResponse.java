package school.sptech.projetoconsultorio.dto.doctor;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DoctorAppointmentResponse {
    private int id;
    private String name;
    private LocalDate dateScheduled;
    private double price;
    private String location;
}
