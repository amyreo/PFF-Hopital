package org.mycompany.repo;

import org.mycompany.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicamentRepository extends JpaRepository<Medicament, Integer>{
	
	

}
