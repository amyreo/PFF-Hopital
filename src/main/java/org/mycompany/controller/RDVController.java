package org.mycompany.controller;

import java.util.List;

import org.mycompany.model.RDV;
import org.mycompany.repo.IRDVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RDVController {

	@Autowired
	IRDVRepository irr;

	@GetMapping("/getRDV/{id}")
	public RDV getRDV(@PathVariable int id) {
		return irr.findById(id).get();
	}

	@GetMapping("/getRDVs")
	public List<RDV> getRDVs() {
		return irr.findAll();
	}

	@PostMapping("/saveRDV")
	public void saveRDV(@RequestBody RDV rdv) {
		irr.save(rdv);
		System.out.println("On a bien enregistré la RDV " + rdv.toString());
	}

	@DeleteMapping("/deleteRDV")
	public void deleteRDV(@PathVariable int id) {
		irr.deleteById(id);
		System.out.println("On a bien supprimé le RDV avec l'id " + id);
	}

	@PutMapping("/updateRDV/{id}")
	public RDV updateRDV(@RequestBody RDV newRDV, @PathVariable int id) {
		return irr.findById(id).map(RDV -> {
			RDV.setId(newRDV.getId());
			RDV.setHeureDebut(newRDV.getHeureDebut());
			RDV.setMaladie(newRDV.getMaladie());
			RDV.setChirurgie(newRDV.isChirurgie());
			RDV.setFacture(newRDV.getFacture());
			RDV.setMedecin(newRDV.getMedecin());
			RDV.setPatient(newRDV.getPatient());
			return irr.save(RDV);
		}).orElseGet(() -> {
			return irr.save(newRDV);
		});
	}
}
