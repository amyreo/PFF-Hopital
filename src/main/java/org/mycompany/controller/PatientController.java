package org.mycompany.controller;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.mycompany.model.Patient;
import org.mycompany.model.Patient;
import org.mycompany.repo.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PatientController {
	@Autowired
	ProducerTemplate producerTemplate;
	
	@Autowired
	IPatientRepository ipr;

	@GetMapping("/getPatient/{id}")
	public Patient getPatient(@PathVariable int id) {
		return ipr.findById(id).get();
	}

	@GetMapping("/getPatients")
	public List<Patient> getPatients() {
		return ipr.findAll();
	}

	@PostMapping("/savePatient")
	public void savePatient(@RequestBody Patient pat) {
		ipr.save(pat);
		System.out.println("On a bien enregistré la Patient " + pat.toString());
	}

	@DeleteMapping("/deletePatient")
	public void deletePatient(@PathVariable int id) {
		ipr.deleteById(id);
		System.out.println("On a bien supprimé le patient avec l'id " + id);
	}

	@PutMapping("/updatePatient/{id}")
	public Patient updatePatient(@RequestBody Patient newPatient, @PathVariable int id) {
		return ipr.findById(id).map(Patient -> {
			Patient.setId(newPatient.getId());
			Patient.setNom(newPatient.getNom());
			Patient.setPrenom(newPatient.getPrenom());
			Patient.setAge(newPatient.getAge());
			Patient.setListeMedecins(newPatient.getListeMedecins());
			Patient.setListeRDV(newPatient.getListeRDV());
			Patient.setListeOrdonances(newPatient.getListeOrdonances());
			return ipr.save(Patient);
		}).orElseGet(() -> {
			return ipr.save(newPatient);
		});
	}
	
	@GetMapping("/clientQuestion")
	public void  getlistClients()
	{
		 
	 producerTemplate.requestBody("direct:patient", null,String.class);
		}
	
}
