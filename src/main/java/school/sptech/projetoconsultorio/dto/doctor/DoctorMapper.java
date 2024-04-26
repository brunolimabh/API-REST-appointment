package school.sptech.projetoconsultorio.dto.doctor;

import school.sptech.projetoconsultorio.entity.Appointment;
import school.sptech.projetoconsultorio.entity.Doctor;

import java.util.List;

public class DoctorMapper {
    public static Doctor toEntity(DoctorRequest dto){
        if (dto == null) return null;

        Doctor entity = new Doctor();
        entity.setName(dto.getName());
        entity.setCrm(dto.getCrm());
        return entity;
    }

    public static DoctorResponse toDto(Doctor entity){
        if (entity == null) return null;

        DoctorResponse dto = new DoctorResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCrm(entity.getCrm());
        dto.setAppointments(toAppointmentDto(entity.getAppointments()));
        return dto;
    }

    public static Doctor toEntityAtt(DoctorRequestUpdate dto, Doctor entity){
        if (dto == null) return null;

        entity.setName(dto.getName());
        entity.setCrm(dto.getCrm());
        return entity;
    }

    public static List<DoctorResponse> toDto(List<Doctor> entities){
        return entities.stream()
                .map(DoctorMapper::toDto)
                .toList();
    }

    public static DoctorAppointmentResponse toAppointmentDto(Appointment entity) {
        if (entity == null) return null;

        DoctorAppointmentResponse dto = new DoctorAppointmentResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDateScheduled(entity.getDateScheduled());
        dto.setPrice(entity.getPrice());
        dto.setLocation(entity.getLocation());
        return dto;
    }

    public static List<DoctorAppointmentResponse> toAppointmentDto(List<Appointment> entities){
        return entities.stream()
                .map(DoctorMapper::toAppointmentDto)
                .toList();
    }
}
