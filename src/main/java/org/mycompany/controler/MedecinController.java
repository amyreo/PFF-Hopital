package org.mycompany.controler;


import org.mycompany.model.Medecin;
import org.mycompany.repo.IMedecinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController

public class MedecinController {

	private Logger logger = LoggerFactory.getLogger(MedecinController.class);
	
	@Autowired
	IMedecinRepository iMedecinRepository;
	
	    @GetMapping("/medecins")
	    public Iterable<Medecin> getMedecins() {
	    	logger.info("les medecins : " + iMedecinRepository.findAll());
	        return iMedecinRepository.findAll();

	    }
	    
	    @GetMapping("/getmedecin/{id}")
	    public Medecin getMedecin(@PathVariable int id){
	    	logger.info("le medecin : " + iMedecinRepository.findById(id));
	    	return iMedecinRepository.findById(id).get();
	    }

	    @PostMapping("/setMedecin")
	    public Medecin createMedecin(@RequestBody Medecin medecin) {
	    	iMedecinRepository.save(medecin);
	    	logger.info("creation du medecin : " + iMedecinRepository.findById(medecin.getIdMede()));
	       	  return medecin ;
	    }
	    
	    @PutMapping("/updateMedecin/{id}")
		public Medecin updateMedecin(@RequestBody Medecin medecin, @PathVariable int id) {
			return iMedecinRepository.findById(id).map(Medecin -> {
				Medecin.setIdMede(medecin.getIdMede());
				Medecin.setNom(medecin.getNom());
				Medecin.setPrenom(medecin.getPrenom());
				Medecin.setRole(medecin.getRole());
				Medecin.setRdv(medecin.getRdv());
				Medecin.setOrdonances(medecin.getOrdonances());
				Medecin.setListePatients(medecin.getListePatients());
				return iMedecinRepository.save(Medecin);
			}).orElseGet(() -> {
				return iMedecinRepository.save(medecin);
			});
		}

}
