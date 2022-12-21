package org.mycompany.controller;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.apache.camel.json.simple.JsonObject;
import org.mycompany.Test;

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

import com.bazaarvoice.jolt.JsonUtils;
import com.bazaarvoice.jolt.Chainr;

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

	@GetMapping("/factureToJSON/{id}/{filename}")
	public void factureToJSON(@PathVariable int id, @PathVariable String filename) {
		Facture fac = ifr.findById(id).get();

		JsonObject factureJSON = new JsonObject();
		factureJSON.put("id", fac.getId());
		factureJSON.put("montant", fac.getMontant());

		JsonObject factureObject = new JsonObject();
		factureObject.put("facture", factureJSON);

		try (FileWriter file = new FileWriter(filename)) {
			String output = factureObject.toJson().toString();
			file.write(output);
			file.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/JSONSpecToString/{id}/{filename}")
	public String JSONSpecToString(@PathVariable int id, @PathVariable String filename) {
		File file = new File(filename);
		file.delete();
		System.out.println("On a supprimé l'object précédent " + filename);
		factureToJSON(id, filename);
		System.out.println("On a créé l'object input.json");

		Object input = JsonUtils.filepathToObject(filename);
		List<Object> chainrSpecJSON = JsonUtils.filepathToList("spec.json");
		Chainr chainr = Chainr.fromSpec(chainrSpecJSON);
		Object output = chainr.transform(input);
		String finalOutput = JsonUtils.toPrettyJsonString(output);
		System.out.println(finalOutput);
		return finalOutput;
		
// à envoyer dans une queue activeMQ
// rajouter un rdv dans la base ? Une fois qu'on aura fait un choice pour ajouter tout ce qu'on veut
		
// Test Numéro 2
// Test Numéro 3 Jenkins
// Test Numéro 4 Jenkins

	}
}
