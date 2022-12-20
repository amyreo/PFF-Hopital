package org.mycompany.repo;

import org.mycompany.model.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface IChambreRepository extends JpaRepository<Chambre, Integer> {

}
