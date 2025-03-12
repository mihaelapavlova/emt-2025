package mk.ukim.finki.emt2025.service;

import mk.ukim.finki.emt2025.model.Book;
import mk.ukim.finki.emt2025.model.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book>findAll();
    Optional<Book>findbyid(Long id);
    Optional<Book> update(Long id,BookDto book);
    Optional<Book>save(BookDto book);
    void deleteById(Long id);
}
