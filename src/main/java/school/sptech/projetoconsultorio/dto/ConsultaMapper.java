package school.sptech.projetoconsultorio.dto;

import school.sptech.projetoconsultorio.entity.Consulta;
import school.sptech.projetoconsultorio.repository.ConsultaRepository;

import java.util.List;

public class ConsultaMapper {

    public static Consulta toEntity(ConsultaRequest dto){
        if (dto == null) return null;

        Consulta entity = new Consulta();
        entity.setNome(dto.getNome());
        entity.setDataAgendamento(dto.getDataAgendamento());
        entity.setPreco(dto.getPreco());
        entity.setLocal(dto.getLocal());
        return entity;
    }

    public static ConsultaResponse toDto(Consulta entity){
        if (entity == null) return null;

        ConsultaResponse dto = new ConsultaResponse();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDataAgendamento(entity.getDataAgendamento());
        dto.setPreco(entity.getPreco());
        dto.setLocal(entity.getLocal());
        dto.setMedico(entity.getMedico());
        return dto;
    }

    public static List<ConsultaResponse> toDto(List<Consulta> entities){
        return entities.stream()
                .map(ConsultaMapper::toDto)
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
