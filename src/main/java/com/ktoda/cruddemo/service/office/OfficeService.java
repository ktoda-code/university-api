package com.ktoda.cruddemo.service.office;

import com.ktoda.cruddemo.entity.office.Office;
import com.ktoda.cruddemo.repository.office.OfficeRepository;
import com.ktoda.cruddemo.service.utility.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficeService implements CrudService<Office> {
    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Override
    public Office save(Office entity) {
        return officeRepository.save(entity);
    }

    @Override
    public Iterable<Office> findAll() {
        return officeRepository.findAll();
    }

    @Override
    public Office findById(Integer id) {
        return officeRepository.findById(id) // Hard coded exception
                .orElseThrow(() -> new RuntimeException("Office not found!"));
    }

    @Override
    public void deleteById(Integer id) {
        officeRepository.deleteById(id);
    }
}
