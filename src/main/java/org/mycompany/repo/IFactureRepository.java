package org.mycompany.repo;

import org.mycompany.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFactureRepository extends JpaRepository<Facture, Integer> {

}
