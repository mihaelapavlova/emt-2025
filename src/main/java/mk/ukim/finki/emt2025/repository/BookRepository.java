package mk.ukim.finki.emt2025.repository;


import mk.ukim.finki.emt2025.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
