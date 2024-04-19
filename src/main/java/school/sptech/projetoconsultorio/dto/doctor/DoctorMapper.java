package school.sptech.projetoconsultorio.dto.doctor;

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
}
