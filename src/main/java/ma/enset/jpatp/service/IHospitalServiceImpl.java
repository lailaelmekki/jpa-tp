package ma.enset.jpatp.service;

import jakarta.transaction.Transactional;
import ma.enset.jpatp.entities.Consultation;
import ma.enset.jpatp.entities.Medecin;
import ma.enset.jpatp.entities.Patient;
import ma.enset.jpatp.entities.RendezVous;
import ma.enset.jpatp.reposetories.ConsultationRepository;
import ma.enset.jpatp.reposetories.MedecinRepository;
import ma.enset.jpatp.reposetories.PatientRepository;
import ma.enset.jpatp.reposetories.RendezVousRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public IHospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
