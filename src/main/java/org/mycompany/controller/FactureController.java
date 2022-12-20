package org.mycompany.controller;

import java.util.List;

import org.mycompany.model.Facture;
import org.mycompany.model.Facture;
import org.mycompany.repo.IFactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactureController {
	@Autowired
	IFactureRepository ifr;

	@GetMapping("/getFacture/{id}")
	public Facture getFacture(@PathVariable int id) {
		return ifr.findById(id).get();
	}

	@GetMapping("/getFactures")
	public List<Facture> getFactures() {
		return ifr.findAll();
	}

	@PostMapping("/saveFacture")
	public void saveFacture(@RequestBody Facture fac) {
		ifr.save(fac);
		System.out.println("On a bien enregistré la Facture " + fac.toString());
	}

	@DeleteMapping("/deleteFacture")
	public void deleteFacture(@PathVariable int id) {
		ifr.deleteById(id);
		System.out.println("On a bien supprimé la Facture avec l'id " + id);
	}

	@PutMapping("/updateFacture/{id}")
	public Facture updateFacture(@RequestBody Facture newFacture, @PathVariable int id) {
		return ifr.findById(id).map(Facture -> {
			Facture.setId(newFacture.getId());
			Facture.setMontant(newFacture.getMontant());
			Facture.setRdv(newFacture.getRdv());
			return ifr.save(Facture);
		}).orElseGet(() -> {
			return ifr.save(newFacture);
		});
	}
}
