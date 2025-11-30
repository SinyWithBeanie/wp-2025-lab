package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    // Custom query methods (optional)
    List<Author> findByNameContainingIgnoreCase(String name);

    List<Author> findBySurnameContainingIgnoreCase(String surname);
}
