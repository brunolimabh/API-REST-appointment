package school.sptech.projetoconsultorio.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetoconsultorio.constants.ConsultaConstants;
import school.sptech.projetoconsultorio.dto.ConsultaMapper;
import school.sptech.projetoconsultorio.dto.ConsultaRequest;
import school.sptech.projetoconsultorio.dto.ConsultaResponse;
import school.sptech.projetoconsultorio.repository.ConsultaRepository;
import school.sptech.projetoconsultorio.service.ConsultaService;

import java.util.List;

@RestController
@RequestMapping(ConsultaConstants.BASE_PATH)
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaRepository consultaRepository = null;
    ConsultaService consultaService = new ConsultaService(consultaRepository);

    @PostMapping
    public ResponseEntity<ConsultaResponse> create(
            @Valid @RequestBody ConsultaRequest body){
        return ResponseEntity.ok(consultaService.create(body));
    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponse>> list(){
        return ResponseEntity.status(200).body(consultaService.list());
    }

    @GetMapping(ConsultaConstants.ID_PATH)
    public ResponseEntity<ConsultaResponse> listById(
            @PathVariable int id){
        return ResponseEntity.status(200).body(consultaService.listById(id));
    }

    @GetMapping(ConsultaConstants.CONSULTS_BY_MEDICO_PATH)
    public ResponseEntity<List<ConsultaResponse>> consultByMedico(
            @PathVariable int medicoId){
        return ResponseEntity.status(200).body(consultaService.consultByMedico(medicoId));
    }

    @GetMapping(ConsultaConstants.AVG_PRICE_CONSULT)
    public ResponseEntity<Double> avgPrice(){
        return ResponseEntity.status(200).body(consultaService.avgPrice());
    }

    @GetMapping(ConsultaConstants.SUM_PRICE_CONSULT_BY_MEDICO)
    public ResponseEntity<Double> sumPriceConsultByMedico(
            @PathVariable int medicoId){
        return ResponseEntity.status(200).body(consultaService.sumPriceConsultByMedico(medicoId));
    }

//    @DeleteMapping(ConsultaConstants.ID_PATH)
//    public ResponseEntity<Void> remove(
//            @PathVariable int id){
//        return ResponseEntity.status(200).body(consultaService.remove(id));
//    }
}
