package mk.ukim.finki.emt2025.web;

import mk.ukim.finki.emt2025.model.Book;
import mk.ukim.finki.emt2025.model.dto.BookDto;
import mk.ukim.finki.emt2025.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findbyid(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
   }
    @PostMapping("/add")
    public ResponseEntity<Book> save (@RequestBody BookDto book){
        return bookService.save(book)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody BookDto book){
        return bookService.update(id,book)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
   }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (bookService.findbyid(id).isPresent()) {
            bookService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
