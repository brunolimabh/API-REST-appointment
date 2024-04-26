package school.sptech.projetoconsultorio.dto.doctor;

import lombok.Data;

import java.util.List;

@Data
public class DoctorResponse {
    private int id;
    private String name;
    private String crm;
    private List<DoctorAppointmentResponse> appointments;
}
