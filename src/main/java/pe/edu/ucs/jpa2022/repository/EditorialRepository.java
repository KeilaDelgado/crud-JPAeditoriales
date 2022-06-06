package pe.edu.ucs.jpa2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.ucs.jpa2022.entity.Editorial;

/**
 *
 * @author admin
 */
@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer>{
    
}
