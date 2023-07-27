package com.ktoda.cruddemo.service.techpersonal;

import com.ktoda.cruddemo.entity.techpersonal.TechPersonal;
import com.ktoda.cruddemo.repository.techpersonal.TechPersonalRepository;
import com.ktoda.cruddemo.service.utility.CrudService;
import com.ktoda.cruddemo.service.utility.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechPersonalService implements UserService, CrudService<TechPersonal> {
    private final TechPersonalRepository techPersonalRepository;

    @Autowired
    public TechPersonalService(TechPersonalRepository techPersonalRepository) {
        this.techPersonalRepository = techPersonalRepository;
    }

    @Override
    public String generateUsername(String firstName) {
        return "admin@" + firstName.toLowerCase();
    }

    @Override
    public String generateEmail(String firstName, String lastName) {
        String techEmail = "@tech.com";
        return firstName.toLowerCase().charAt(0) + lastName.toLowerCase() + techEmail;
    }

    @Override
    public TechPersonal save(TechPersonal entity) {
        entity.setUsername(generateUsername(entity.getFirstName()));
        entity.setEmail(generateEmail(
                entity.getFirstName(),
                entity.getLastName()));
        return techPersonalRepository.save(entity);
    }

    @Override
    public Iterable<TechPersonal> findAll() {
        return techPersonalRepository.findAll();
    }

    @Override
    public TechPersonal findById(Integer id) {
        return techPersonalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found!"));
    }

    @Override
    public void deleteById(Integer id) {
        techPersonalRepository.deleteById(id);
    }

    public TechPersonal findByUsername(String username) {
        return techPersonalRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Not found!"));
    }
}
