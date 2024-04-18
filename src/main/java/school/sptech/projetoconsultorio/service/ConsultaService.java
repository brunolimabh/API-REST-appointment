package school.sptech.projetoconsultorio.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projetoconsultorio.dto.ConsultaMapper;
import school.sptech.projetoconsultorio.dto.ConsultaRequest;
import school.sptech.projetoconsultorio.dto.ConsultaResponse;
import school.sptech.projetoconsultorio.entity.Consulta;
import school.sptech.projetoconsultorio.repository.ConsultaRepository;

import javax.naming.NotContextException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private static ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public ConsultaResponse create(ConsultaRequest body){
        Consulta entity = ConsultaMapper.toEntity(body);
        Consulta saveEntity = consultaRepository.save(entity);
        return ConsultaMapper.toDto(saveEntity);
    }

    public List<ConsultaResponse> list(){
       List<Consulta> entities = consultaRepository.findAll();
       if (entities.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
       return ConsultaMapper.toDto(entities);
    }

    public ConsultaResponse listById(int id){
        Optional<Consulta> entity = consultaRepository.findById(id);
        if (entity.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return ConsultaMapper.toDto(entity.get());
    }

    public List<ConsultaResponse> consultByMedico(int medicoId){
        List<Consulta> entities = consultaRepository.findByMedicoId(medicoId);
        if (entities.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return ConsultaMapper.toDto(entities);
    }

    public double avgPrice(){
        return consultaRepository.avgConsultPrice();
    }

    public double sumPriceConsultByMedico(int medicoId){
        return consultaRepository.sumConsultPriceByMedico(medicoId);
    }

    public void remove(int id){
        Optional<Consulta> entity = consultaRepository.findById(id);
        if (entity.isEmpty()) {}
        consultaRepository.existsById(id);
    }
}
