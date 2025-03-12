package mk.ukim.finki.emt2025.web;

import mk.ukim.finki.emt2025.model.Author;
import mk.ukim.finki.emt2025.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    public final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping
    public List<Author> findAll() {
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return this.authorService.findbyid(id)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Author> save(@RequestBody Author author) {
        return this.authorService.save(author)
                .map(m -> ResponseEntity.ok().body(m))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Author> update(@PathVariable Long id, @RequestBody Author author) {
        return this.authorService.update(id, author)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (authorService.findbyid(id).isPresent()) {
            authorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
