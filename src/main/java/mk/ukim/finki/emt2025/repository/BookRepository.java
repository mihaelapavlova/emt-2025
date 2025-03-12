package mk.ukim.finki.emt2025.repository;


import mk.ukim.finki.emt2025.model.Book;
import mk.ukim.finki.emt2025.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByCategory(Category category);
}
