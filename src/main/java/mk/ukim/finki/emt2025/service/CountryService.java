package mk.ukim.finki.emt2025.service;


import mk.ukim.finki.emt2025.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findbyid(Long id);
    Optional<Country> update(Long id, Country country);
    Optional<Country> save(Country country);
    void deleteById(Long id);
}
