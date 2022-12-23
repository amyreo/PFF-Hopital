package org.mycompany.controller;

import java.util.List;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.mycompany.model.Patient;
import org.mycompany.repo.IPatientRepository;
import org.mycompany.route.PatientRouter;
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

	private static String url = "tcp://194.206.91.85:61616";

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

	@GetMapping("/clientQuestion/{question}")
	public void premiereQuestion(@PathVariable String question) throws Exception {
		CamelContext context = new DefaultCamelContext();
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		connectionFactory.createConnection("admin", "adaming2022");
		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		context.addRoutes(new PatientRouter());
		context.start();
		producerTemplate.sendBody("jms:queue:JT_ReponseMedecin", question);
		System.out.println("On a bien envoyé la question " + question + " au médecin.");
		context.stop();
		

//		producerTemplate.requestBody("direct:patient", null, String.class);
	}

}
