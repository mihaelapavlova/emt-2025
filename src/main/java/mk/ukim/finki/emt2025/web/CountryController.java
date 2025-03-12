package mk.ukim.finki.emt2025.web;

import jakarta.transaction.Transactional;
import mk.ukim.finki.emt2025.model.Country;
import mk.ukim.finki.emt2025.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> findAll(){
        return this.countryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id){
        return countryService.findbyid(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Country> save(@RequestBody Country category) {
        return countryService.save(category)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> update(@PathVariable Long id, @RequestBody Country country) {
        return countryService.update(id, country)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (countryService.findbyid(id).isPresent()) {
            countryService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

