package school.sptech.projetoconsultorio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projetoconsultorio.dto.appointment.AppointmentMapper;
import school.sptech.projetoconsultorio.dto.appointment.AppointmentRequest;
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

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    public Appointment create(AppointmentRequest body){
        Optional<Doctor> entityDoctor = doctorRepository.findById(body.getDoctorId());
        if (entityDoctor.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        Appointment entity = AppointmentMapper.toEntity(body, entityDoctor.get());
        Appointment saveEntity = appointmentRepository.save(entity);
        return saveEntity;
    }

    public List<Appointment> list(){
       List<Appointment> entities = appointmentRepository.findAll();
       if (entities.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
       return entities;
    }

    public Appointment listById(int id){
        Optional<Appointment> entity = appointmentRepository.findById(id);
        if (entity.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return entity.get();
    }

    public List<Appointment> listByDoctor(int doctorId){
        List<Appointment> entities = appointmentRepository.findByDoctorId(doctorId);
        if (entities.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return entities;
    }

    public double avgPrice(){
        return appointmentRepository.avgPrice();
    }

    public double sumPriceByDoctor(int doctorId){
        return appointmentRepository.sumPriceByDoctor(doctorId);
    }

    public List<Appointment> listByDoctorAndDate(int doctorId, LocalDate dateInicial, LocalDate dateFinal){
        List<Appointment> entities = appointmentRepository.findByDoctorIdAndDateScheduledBetween(doctorId, dateInicial, dateFinal);
        if (entities.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return entities;
    }

    public Void updateName(int id, String name){
        Optional<Appointment> entity = appointmentRepository.findById(id);
        if (entity.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        appointmentRepository.updateName(id, name);
        return null;
    }

    public Void remove(int id){
        Optional<Appointment> entity = appointmentRepository.findById(id);
        if (entity.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        appointmentRepository.deleteById(id);
        return null;
    }
}
