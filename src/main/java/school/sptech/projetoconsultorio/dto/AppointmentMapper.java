package school.sptech.projetoconsultorio.dto;

import school.sptech.projetoconsultorio.entity.Appointment;
import school.sptech.projetoconsultorio.entity.Doctor;

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
        dto.setDoctor(entity.getDoctor());
        return dto;
    }

    public static List<AppointmentResponse> toDto(List<Appointment> entities){
        return entities.stream()
                .map(AppointmentMapper::toDto)
                .toList();
    }

//
//    public static Cliente toEntityAtt(ClienteRequestUpdateDto dto, Cliente entity){
//        if (dto == null) return null;
//
//        entity.setNome(dto.getNome());
//        entity.setEmail(dto.getEmail());
//        entity.setSenha(dto.getSenha());
//        entity.setCpf(dto.getCpf());
//        entity.setTelefone(dto.getTelefone());
//        entity.setDataNascimento(dto.getDataNascimento());
//        return entity;
//    }
//
}
