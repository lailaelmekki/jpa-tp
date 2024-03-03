package ma.enset.jpatp;

import ma.enset.jpatp.entities.*;
import ma.enset.jpatp.reposetories.ConsultationRepository;
import ma.enset.jpatp.reposetories.MedecinRepository;
import ma.enset.jpatp.reposetories.PatientRepository;
import ma.enset.jpatp.reposetories.RendezVousRepository;
import ma.enset.jpatp.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class JpaTpApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaTpApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService,
                            MedecinRepository medecinRepository ,PatientRepository patientRepository,RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository){
        return args->{
            Stream.of("Mohamed","Hassan","Najat")
                    .forEach(name->{
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);

                    });
            Stream.of("laila","imane","anas")
                    .forEach(name->{
                        Medecin medecin=new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"cardio":"dentiste");
                        hospitalService.saveMedecin(medecin);

                    });
            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("Mohamed");
            Medecin medecin=medecinRepository.findByNom("anas");
            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            rendezVousRepository.save(rendezVous);

            RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);

            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de consultation....");
            hospitalService.saveConsultation(consultation);







        };

    }
}
