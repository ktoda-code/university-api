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
    public TechPersonal save(TechPersonal entity) {
        entity.setUsername(generateUsername(entity.getFirstName()));
        return techPersonalRepository.save(entity);
    }

    @Override
    public Iterable<TechPersonal> findAll() {
        return null;
    }

    @Override
    public TechPersonal findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
