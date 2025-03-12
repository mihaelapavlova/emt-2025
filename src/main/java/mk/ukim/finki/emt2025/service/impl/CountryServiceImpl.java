package mk.ukim.finki.emt2025.service.impl;

import mk.ukim.finki.emt2025.model.Country;
import mk.ukim.finki.emt2025.repository.CountryRepository;
import mk.ukim.finki.emt2025.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findbyid(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> update(Long id, Country country) {
        return countryRepository.findById(id)
                .map(existingCountry -> {
                    if(country.getName() !=null){
                        existingCountry.setName(country.getName());
                    }
                    if(country.getContinent() !=null){
                        existingCountry.setContinent(country.getContinent());
                    }
                    return this.countryRepository.save(existingCountry);
                });
    }

    @Override
    public Optional<Country> save(Country country) {
        return Optional.of(this.countryRepository.save(country));
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }
}
