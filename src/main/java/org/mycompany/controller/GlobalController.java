package org.mycompany.controller;

import java.util.Scanner;

import org.mycompany.model.Chambre;
import org.mycompany.model.Facture;
import org.mycompany.model.Medecin;
import org.mycompany.model.Ordonance;
import org.mycompany.model.Patient;
import org.mycompany.repo.IChambreRepository;
import org.mycompany.repo.IFactureRepository;
import org.mycompany.repo.IMedecinRepository;
import org.mycompany.repo.IOrdonanceRepository;
import org.mycompany.repo.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalController {

	@Autowired
	IPatientRepository ipr;
	@Autowired
	IMedecinRepository imr;
	@Autowired
	IFactureRepository ifr;
	@Autowired
	IOrdonanceRepository ior;
	@Autowired
	IChambreRepository icr;

	public Scanner scan = new Scanner(System.in);

	@GetMapping("/mainMenu")
	public void mainMenu() throws Exception {

		int choice = 0;
		do {
			System.err.println(
					"Tapez 1 pour ajouter un patient, 2 pour lister tous les patients, 3 pour voir un patient en particulier, 4 pour supprimer un patient.");
			System.out.println(
					"Tapez 5 pour ajouter un médecin, 6 pour lister tous les médecins, 7 pour voir un médecin en particulier, 8 pour supprimer un médecin.");
			System.err.println(
					"Tapez 9 pour ajouter une chambre, 10 pour lister toutes les chambres, 11 pour voir une chambre en particulier, 12 pour supprimer une chambre.");
			System.out.println(
					"Tapez 13 pour ajouter une facture, 14 pour lister toutes les factures, 15 pour voir une facture en particulier, 16 pour supprimer une facture.");
			System.err.println(
					"Tapez 17 pour ajouter une ordonnance, 18 pour lister toutes les ordonnances, 19 pour voir une ordonnance en particulier, 20 pour supprimer une ordonnance.");
			System.out.println("Tapez 21 pour planifier un RDV, 22 pour consulter le planning des RDV.");
			System.err.println("Pour ajouter un objet en tant qu'attribut d'une autre objet, veuillez d'abord créer les deux objets séparément.");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Entrez l'identifiant du patient : ");
				int id = scan.nextInt();
				System.out.println("Entrez le nom du patient : ");
				String nom = scan.next();
				System.out.println("Entrez le prénom du patient : ");
				String prenom = scan.next();
				System.out.println("Entrez l'âge du patient : ");
				int age = scan.nextInt();
				Patient patient = new Patient(id, nom, prenom, age);
				ipr.save(patient);
				System.out.println("Le patient a bien été enregistré.");
				break;

			case 2:
				System.out.println("Allez à l'adresse suivante svp : ");
				System.err.println("localhost:8080/getPatients");
				break;
			case 3:
				System.out.println("Quel est l'identifiant du patient que vous souhaitez visualiser ?");
				int id2 = scan.nextInt();
				System.out.println("Rendez-vous à l'adresse suivante : ");
				System.err.println("localhost:8080/getPatient/" + id2);
				break;
			case 4:
				System.out.println("Quel est l'identifiant du patient que vous souhaitez supprimer ?");
				int id3 = scan.nextInt();
				System.out.println("Rendez-vous à l'adresse suivante : ");
				System.err.println("localhost:8080/deletePatient/" + id3);
				break;
			case 5:

				System.out.println("Entrez l'identifiant du médecin : ");
				int idm = scan.nextInt();
				System.out.println("Entrez le nom du médecin : ");
				String nomm = scan.next();
				System.out.println("Entrez le prénom du médecin : ");
				String prenomm = scan.next();
				System.out.println("Entrez la profession du médecin : ");
				String role = scan.next();
				Medecin med = new Medecin(idm, nomm, prenomm, role);
				imr.save(med);
				System.out.println("Le médecin a bien été enregistré.");
				break;
			case 6:
				System.out.println("Allez à l'adresse suivante svp : ");
				System.err.println("localhost:8080/getMedecins");
				break;
			case 7:
				System.out.println("Quel est l'identifiant du médecin que vous souhaitez visualiser ?");
				int id4 = scan.nextInt();
				System.out.println("Rendez-vous à l'adresse suivante : ");
				System.err.println("localhost:8080/getMedecin/" + id4);
				break;
			case 8:
				System.out.println("Quel est l'identifiant du médecin que vous souhaitez supprimer ?");
				int id5 = scan.nextInt();
				System.out.println("Rendez-vous à l'adresse suivante : ");
				System.err.println("localhost:8080/deleteMedecin/" + id5);
				break;
			case 9:
				System.out.println("Entrez l'identifiant de la chambre : ");
				int idc = scan.nextInt();
				System.out.println("Entrez la taille de la chambre en m2 (entiers seulement) : ");
				int superficie = scan.nextInt();
				Chambre chambre = new Chambre(idc, superficie);
				icr.save(chambre);
				System.out.println("La chambre a bien été enregistrée.");
				break;
			case 10:
				System.out.println("Allez à l'adresse suivante svp : ");
				System.err.println("localhost:8080/getChambres");
				break;
			case 11:
				System.out.println("Quel est l'identifiant de la chambre que vous souhaitez visualiser ?");
				int id6 = scan.nextInt();
				System.out.println("Rendez-vous à l'adresse suivante : ");
				System.err.println("localhost:8080/getChambre/" + id6);
				break;
			case 12:
				System.out.println("Quel est l'identifiant de la chambre que vous souhaitez supprimer ?");
				int id7 = scan.nextInt();
				System.out.println("Rendez-vous à l'adresse suivante : ");
				System.err.println("localhost:8080/deleteChambre/" + id7);
				break;
			case 13:
				System.out.println("Entrez l'identifiant de la facture : ");
				int idf = scan.nextInt();
				System.out.println("Entrez le montant de la facture : ");
				double montant = scan.nextDouble();
				Facture fac = new Facture(idf, montant);
				ifr.save(fac);
				System.out.println("La facture a bien été enregistrée.");
				break;
			case 14:
				System.out.println("Allez à l'adresse suivante svp : ");
				System.err.println("localhost:8080/getFactures");
				break;
			case 15:
				System.out.println("Quel est l'identifiant de la facture que vous souhaitez visualiser ?");
				int id8 = scan.nextInt();
				System.out.println("Rendez-vous à l'adresse suivante : ");
				System.err.println("localhost:8080/getFacture/" + id8);
				break;
			case 16:
				System.out.println("Quel est l'identifiant de la facture que vous souhaitez supprimer ?");
				int id9 = scan.nextInt();
				System.out.println("Rendez-vous à l'adresse suivante : ");
				System.err.println("localhost:8080/deleteFacture/" + id9);
				break;
			case 17:
				System.out.println("Entrez l'identifiant de l'ordonnance : ");
				int ido = scan.nextInt();
				Ordonance ord = new Ordonance(ido, null);
				ior.save(ord);
				System.out.println("L'ordonnance a bien été enregistrée.");
				break;
			case 18:
				System.out.println("Allez à l'adresse suivante svp : ");
				System.err.println("localhost:8080/getOrdonances");
				break;
			case 19:
				System.out.println("Quel est l'identifiant de l'ordonnance que vous souhaitez visualiser ?");
				int id10 = scan.nextInt();
				System.out.println("Rendez-vous à l'adresse suivante : ");
				System.err.println("localhost:8080/getOrdonance/" + id10);
				break;
			case 20:
				System.out.println("Quel est l'identifiant de l'ordonnance que vous souhaitez supprimer ?");
				int id11 = scan.nextInt();
				System.out.println("Rendez-vous à l'adresse suivante : ");
				System.err.println("localhost:8080/deleteOrdonance/" + id11);
				break;
			case 21:
				break;
			case 22:
				break;

			default:
				break;
			}
		} while (choice < 23);
	}

}
