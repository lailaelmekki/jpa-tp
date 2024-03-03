package ma.enset.jpatp.service;

import ma.enset.jpatp.entities.Consultation;
import ma.enset.jpatp.entities.Medecin;
import ma.enset.jpatp.entities.Patient;
import ma.enset.jpatp.entities.RendezVous;

public interface IHospitalService {
     Patient savePatient(Patient patient);
     Medecin saveMedecin(Medecin medecin);
     RendezVous saveRDV(RendezVous rendezVous);
     Consultation saveConsultation(Consultation consultation);
}
