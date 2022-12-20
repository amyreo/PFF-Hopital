package org.mycompany.repo;

import org.mycompany.model.RDV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRDVRepository extends JpaRepository<RDV, Integer> {

}
