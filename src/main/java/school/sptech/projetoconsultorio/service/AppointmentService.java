package school.sptech.projetoconsultorio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projetoconsultorio.dto.AppointmentMapper;
import school.sptech.projetoconsultorio.dto.AppointmentRequest;
import school.sptech.projetoconsultorio.dto.AppointmentResponse;
import school.sptech.projetoconsultorio.entity.Appointment;
import school.sptech.projetoconsultorio.entity.Doctor;
import school.sptech.projetoconsultorio.repository.AppointmentRepository;
import school.sptech.projetoconsultorio.repository.DoctorRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private static AppointmentRepository appointmentRepository;
    private static DoctorRepository doctorRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
    }

    public AppointmentResponse create(AppointmentRequest body){
        Optional<Doctor> entityDoctor = doctorRepository.findById(body.getDoctorId());
        if (entityDoctor.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        Appointment entity = AppointmentMapper.toEntity(body, entityDoctor.get());
        Appointment saveEntity = appointmentRepository.save(entity);
        return AppointmentMapper.toDto(saveEntity);
    }

    public List<AppointmentResponse> list(){
       List<Appointment> entities = appointmentRepository.findAll();
       if (entities.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
       return AppointmentMapper.toDto(entities);
    }

    public AppointmentResponse listById(int id){
        Optional<Appointment> entity = appointmentRepository.findById(id);
        if (entity.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return AppointmentMapper.toDto(entity.get());
    }

    public List<AppointmentResponse> listByDoctor(int doctorId){
        List<Appointment> entities = appointmentRepository.findByDoctorId(doctorId);
        if (entities.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return AppointmentMapper.toDto(entities);
    }

    public double avgPrice(){
        return appointmentRepository.avgPrice();
    }

    public double sumPriceByDoctor(int doctorId){
        return appointmentRepository.sumPriceByDoctor(doctorId);
    }

    public List<AppointmentResponse> listByDoctorAndDate(int doctorId, LocalDate dateInicial, LocalDate dateFinal){
        List<Appointment> entities = appointmentRepository.findByDoctorIdAndDateScheduledBetween(doctorId, dateInicial, dateInicial);
        if (entities.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return AppointmentMapper.toDto(entities);
    }

    public boolean updateName(int id, String name){
        Optional<Appointment> entity = appointmentRepository.findById(id);
        if (entity.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        appointmentRepository.updateName(id, name);
        return true;
    }

    public boolean remove(int id){
        Optional<Appointment> entity = appointmentRepository.findById(id);
        if (entity.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        appointmentRepository.deleteById(id);
        return true;
    }
}
