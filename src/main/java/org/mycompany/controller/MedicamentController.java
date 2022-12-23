package org.mycompany.controller;

import java.util.Optional;

import org.mycompany.model.Medicament;
import org.mycompany.repo.IMedicamentRepository;
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

public class MedicamentController {

	private Logger logger = LoggerFactory.getLogger(MedicamentController.class);

	@Autowired
	IMedicamentRepository iMedicamentRepository;

	@GetMapping("/medicaments")
	public Iterable<Medicament> getMedicaments() {
		logger.info("les medicaments : " + iMedicamentRepository.findAll());
		return iMedicamentRepository.findAll();

	}

	@GetMapping("/getmedicament/{id}")
	public Medicament getMedicament(@PathVariable int id) {
		logger.info("le medicament : " + iMedicamentRepository.findById(id));
		return iMedicamentRepository.findById(id).get();
	}

	@PostMapping("/setMedicament")
	public Medicament createMedicament(@RequestBody Medicament medicament) {
		iMedicamentRepository.save(medicament);
		logger.info("creation du medicament : " + iMedicamentRepository.findById(medicament.getIdMedi()));
		return medicament;
	}

	  @PutMapping("/updateMedicament/{id}")
			public Medicament updateMedicament(@RequestBody Medicament medicament, @PathVariable int id) {
		  return iMedicamentRepository.findById(id).map(Medicament -> {
					Medicament.setIdMedi(medicament.getIdMedi());
					Medicament.setNom (medicament.getNom());
					Medicament.setDescription(medicament.getDescription());
					Medicament.setStock(medicament.getStock());
					Medicament.setOrdonances(medicament.getOrdonances());
					return iMedicamentRepository.save(Medicament);
				}).orElseGet(() -> {
					return iMedicamentRepository.save(medicament);
				});
			}
	  
	  
	  
	  @PutMapping("/updateStockMedicament/{id}/{StockEnlever}")
		public Medicament updateStockMedicament(@PathVariable int id,@PathVariable int StockEnlever) {
		  if ((iMedicamentRepository.findById(id).get().getStock()- StockEnlever)>=0) {
		  return iMedicamentRepository.findById(id).map(Medicament -> {
			  	Medicament.setIdMedi(id);
			  	Medicament.setNom (iMedicamentRepository.getById(id).getNom());
			  	Medicament.setDescription(iMedicamentRepository.getById(id).getDescription());
				Medicament.setStock(iMedicamentRepository.getById(id).getStock( ) + StockEnlever);
				Medicament.setOrdonances(iMedicamentRepository.getById(id).getOrdonances());
				return iMedicamentRepository.save(Medicament);
			}).orElseGet(() -> {
				return null;
			});
		}else {
			System.out.println("stock insufisant");
			return iMedicamentRepository.getById(id);
		}
		 
	  }
		 
	  
	  
	  

}
