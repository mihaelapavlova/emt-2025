package mk.ukim.finki.emt2025.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import mk.ukim.finki.emt2025.model.Author;
import mk.ukim.finki.emt2025.model.Book;
import mk.ukim.finki.emt2025.model.Category;
import mk.ukim.finki.emt2025.model.Country;
import mk.ukim.finki.emt2025.repository.AuthorRepository;
import mk.ukim.finki.emt2025.repository.BookRepository;
import mk.ukim.finki.emt2025.repository.CountryRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataInitializer(CountryRepository countryRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init() {
        Country macedonia = countryRepository.save(new Country("Macedonia", "Europe"));
        Country usa = countryRepository.save(new Country("USA", "North America"));
        Country france = countryRepository.save(new Country("France", "Europe"));
        Country japan = countryRepository.save(new Country("Japan", "Asia"));
        Country brazil = countryRepository.save(new Country("Brazil", "South America"));

        Author author1 = authorRepository.save(new Author("John", "Doe", macedonia));
        Author author2 = authorRepository.save(new Author("Jane", "Smith", usa));
        Author author3 = authorRepository.save(new Author("Pierre", "Dubois", france));
        Author author4 = authorRepository.save(new Author("Hiroshi", "Tanaka", japan));
        Author author5 = authorRepository.save(new Author("Carlos", "Silva", brazil));

        bookRepository.save(new Book("The Great Book", Category.NOVEL, author1, 5));
        bookRepository.save(new Book("History of Time", Category.HISTORY, author2, 3));
        bookRepository.save(new Book("French Poetry", Category.FANTASY, author3, 7));
        bookRepository.save(new Book("Samurai Code", Category.FANTASY, author4, 4));
        bookRepository.save(new Book("Amazon Rainforest", Category.BIOGRAPHY, author5, 6));
        bookRepository.save(new Book("The Hidden Universe", Category.CLASSICS, author1, 8));
        bookRepository.save(new Book("War and Peace 2", Category.CLASSICS, author2, 2));
        bookRepository.save(new Book("Modern Art Explained", Category.BIOGRAPHY, author3, 10));
        bookRepository.save(new Book("Ancient Mythology", Category.HISTORY, author4, 3));
        bookRepository.save(new Book("The Last Adventure", Category.NOVEL, author5, 5));
    }
}

