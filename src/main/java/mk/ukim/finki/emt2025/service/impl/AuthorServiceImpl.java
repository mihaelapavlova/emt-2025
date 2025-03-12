package mk.ukim.finki.emt2025.service.impl;

import mk.ukim.finki.emt2025.model.Author;
import mk.ukim.finki.emt2025.repository.AuthorRepository;
import mk.ukim.finki.emt2025.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findbyid(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> update(Long id, Author author) {
        return authorRepository.findById(id)
                .map(existingAuthor -> {
                    if(author.getName() !=null){
                        existingAuthor.setName(author.getName());
                    }
                    if(author.getSurname() !=null){
                        existingAuthor.setSurname(author.getSurname());
                    }
                    if(author.getCountry() !=null){
                        existingAuthor.setCountry(author.getCountry());
                    }
                    return authorRepository.save(existingAuthor);
                });
    }

    @Override
    public Optional<Author> save(Author author) {
        return Optional.of(this.authorRepository.save(author));
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
