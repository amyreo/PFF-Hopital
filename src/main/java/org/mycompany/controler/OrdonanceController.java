package org.mycompany.controler;



import org.mycompany.model.Ordonance;
import org.mycompany.repo.IOrdonanceRepository;
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

public class OrdonanceController {

	private Logger logger = LoggerFactory.getLogger(OrdonanceController.class);
	
	@Autowired
	IOrdonanceRepository iOrdonanceRepository;
	
	    @GetMapping("/ordonances")
	    public Iterable<Ordonance> getOrdonances() {
	    	logger.info("les ordonances : " + iOrdonanceRepository.findAll());
	        return iOrdonanceRepository.findAll();

	    }
	    
	    @GetMapping("/getordonance/{id}")
	    public Ordonance getOrdonance(@PathVariable int id){
	    	logger.info("le ordonance : " + iOrdonanceRepository.findById(id));
	    	return iOrdonanceRepository.findById(id).get();
	    }

	    @PostMapping("/setOrdonance")
	    public Ordonance createOrdonance(@RequestBody Ordonance ordonance) {
	    	iOrdonanceRepository.save(ordonance);
	    	logger.info("creation du ordonance : " + iOrdonanceRepository.findById(ordonance.getIdOrdo()));
	       	  return ordonance ;
	    }
	    
	    @PutMapping("/updateOrdonance/{id}")
		public Ordonance updateOrdonance(@RequestBody Ordonance ordonance, @PathVariable int id) {
			return iOrdonanceRepository.findById(id).map(Ordonance -> {
				Ordonance.setIdOrdo(ordonance.getIdOrdo());
				Ordonance.setMedecin(ordonance.getMedecin());
				Ordonance.setMedicaments(ordonance.getMedicaments());
				return iOrdonanceRepository.save(Ordonance);
			}).orElseGet(() -> {
				return iOrdonanceRepository.save(ordonance);
			});
		}
	
}
