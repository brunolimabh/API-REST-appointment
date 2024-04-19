package school.sptech.projetoconsultorio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projetoconsultorio.dto.doctor.DoctorMapper;
import school.sptech.projetoconsultorio.dto.doctor.DoctorRequest;
import school.sptech.projetoconsultorio.dto.doctor.DoctorRequestUpdate;
import school.sptech.projetoconsultorio.dto.doctor.DoctorResponse;
import school.sptech.projetoconsultorio.entity.Appointment;
import school.sptech.projetoconsultorio.entity.Doctor;
import school.sptech.projetoconsultorio.repository.AppointmentRepository;
import school.sptech.projetoconsultorio.repository.DoctorRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private static DoctorRepository doctorRepository;
    private static AppointmentRepository appointmentRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, AppointmentRepository appointmentRepository) {
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public DoctorResponse create(DoctorRequest body){
        Doctor entity = DoctorMapper.toEntity(body);
        Doctor saveEntity = doctorRepository.save(entity);
        return DoctorMapper.toDto(saveEntity);
    }

    public List<DoctorResponse> list(){
       List<Doctor> entities = doctorRepository.findAll();
       if (entities.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
       return DoctorMapper.toDto(entities);
    }

    public DoctorResponse listById(int id){
        Optional<Doctor> entity = doctorRepository.findById(id);
        if (entity.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return DoctorMapper.toDto(entity.get());
    }

    public Void update(int id, DoctorRequestUpdate request){
        Optional<Doctor> entity = doctorRepository.findById(id);
        if (entity.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Doctor saveDoctor = doctorRepository.save(DoctorMapper.toEntityAtt(request, entity.get()));
        return null;
    }

    public Void remove(int id){
        Optional<Doctor> entity = doctorRepository.findById(id);
        if (entity.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        List<Appointment> appointments = appointmentRepository.findByDoctorId(id);
        if (!appointments.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        doctorRepository.deleteById(id);
        return null;
    }
}
