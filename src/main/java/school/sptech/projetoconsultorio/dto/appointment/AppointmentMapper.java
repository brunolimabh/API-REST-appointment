package school.sptech.projetoconsultorio.dto.appointment;

import school.sptech.projetoconsultorio.entity.Appointment;
import school.sptech.projetoconsultorio.entity.Doctor;

import javax.print.Doc;
import java.util.List;

public class AppointmentMapper {

    public static Appointment toEntity(AppointmentRequest dto, Doctor entityDoctor){
        if (dto == null) return null;

        Appointment entity = new Appointment();
        entity.setName(dto.getName());
        entity.setDateScheduled(dto.getDateScheduled());
        entity.setPrice(dto.getPrice());
        entity.setLocation(dto.getLocation());
        entity.setDoctor(entityDoctor);
        return entity;
    }

    public static AppointmentResponse toDto(Appointment entity){
        if (entity == null) return null;

        AppointmentResponse dto = new AppointmentResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDateScheduled(entity.getDateScheduled());
        dto.setPrice(entity.getPrice());
        dto.setLocation(entity.getLocation());
        dto.setDoctor(toDoctorDto(entity.getDoctor()));
        return dto;
    }

    public static List<AppointmentResponse> toDto(List<Appointment> entities){
        return entities.stream()
                .map(AppointmentMapper::toDto)
                .toList();
    }

    public static AppointmentDoctorResponse toDoctorDto(Doctor entity) {
        if (entity == null) return null;

        AppointmentDoctorResponse dto = new AppointmentDoctorResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCrm(entity.getCrm());
        return dto;
    }

    public static List<AppointmentDoctorResponse> toDoctorDto(List<Doctor> entities) {
        return entities.stream()
                .map(AppointmentMapper::toDoctorDto)
                .toList();
    }
}
