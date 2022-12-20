package org.mycompany.repo;

import org.mycompany.model.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedecinRepository extends JpaRepository<Medecin, Integer>{
	
	

}
