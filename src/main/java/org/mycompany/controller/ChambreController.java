package org.mycompany.controller;

import java.util.List;

import org.mycompany.model.Chambre;
import org.mycompany.repo.IChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChambreController {

	@Autowired
	IChambreRepository icr;
 
	@GetMapping("/getChambre/{id}")
	public Chambre getChambre(@PathVariable int id) {
		return icr.findById(id).get();
	}

	@GetMapping("/getChambres")
	public List<Chambre> getChambres() {
		return icr.findAll();
	}

	@PostMapping("/saveChambre")
	public void saveChambre(@RequestBody Chambre cha) {
		icr.save(cha);
		System.out.println("On a bien enregistré la chambre " + cha.toString());
	}

	@DeleteMapping("/deleteChambre")
	public void deleteChambre(@PathVariable int id) {
		icr.deleteById(id);
		System.out.println("On a bien supprimé la chambre avec l'id " + id);
	}

	@PutMapping("/updateChambre/{id}")
	public Chambre updateChambre(@RequestBody Chambre newChambre, @PathVariable int id) {
		return icr.findById(id).map(Chambre -> {
			Chambre.setId(newChambre.getId());
			Chambre.setTaille(newChambre.getTaille());
			Chambre.setListePatient(newChambre.getListePatient());
			return icr.save(Chambre);
		}).orElseGet(() -> {
			return icr.save(newChambre);
		});
	}

}
