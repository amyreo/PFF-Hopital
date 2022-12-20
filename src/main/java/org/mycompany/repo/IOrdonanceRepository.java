package org.mycompany.repo;

import org.mycompany.model.Ordonance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdonanceRepository extends JpaRepository<Ordonance, Integer>{
	
	

}
