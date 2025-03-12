package mk.ukim.finki.emt2025.service.impl;

import mk.ukim.finki.emt2025.model.Book;
import mk.ukim.finki.emt2025.model.Category;
import mk.ukim.finki.emt2025.model.dto.BookDto;
import mk.ukim.finki.emt2025.repository.BookRepository;
import mk.ukim.finki.emt2025.service.AuthorService;
import mk.ukim.finki.emt2025.service.BookService;
import mk.ukim.finki.emt2025.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CountryService countryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CountryService countryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findbyid(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> update(Long id, BookDto book) {
        return this.bookRepository.findById(id)
                .map(existingBook -> {
                    if(book.getName() !=null){
                        existingBook.setName(book.getName());
                    }
                    if(book.getCategory() !=null){
                        existingBook.setCategory(book.getCategory());
                    }
                    if(book.getAuthorId() !=null && authorService.findbyid(book.getAuthorId()).isPresent()){
                        existingBook.setAuthor(authorService.findbyid(book.getAuthorId()).get());
                    }
                    if(book.getAvailableCopies() !=null){
                        existingBook.setAvailableCopies(book.getAvailableCopies());
                    }
                    return bookRepository.save(existingBook);
                });
    }

    @Override
    public Optional<Book> save(BookDto book) {
        if(book.getCategory() !=null && authorService.findbyid(book.getAuthorId()).isPresent()){
            return Optional.of(
                    this.bookRepository.save(new Book(book.getName(), book.getCategory(),
                            authorService.findbyid(book.getAuthorId()).get(), book.getAvailableCopies())));
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
    @Override
    public List<Book> findByCategory(Category category) {
        return this.bookRepository.findByCategory(category);
    }
}
