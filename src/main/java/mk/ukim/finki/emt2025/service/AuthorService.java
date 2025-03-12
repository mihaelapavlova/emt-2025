package mk.ukim.finki.emt2025.service;

import mk.ukim.finki.emt2025.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findbyid(Long id);
    Optional<Author> update(Long id, Author author);
    Optional<Author> save (Author author);
    void deleteById(Long id);
}
