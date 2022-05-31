package pe.edu.ucs.jpa2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.ucs.jpa2022.entity.Post;

/**
 *
 * @author admin
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
    
}
