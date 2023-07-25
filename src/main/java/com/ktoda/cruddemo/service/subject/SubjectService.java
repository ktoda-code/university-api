package com.ktoda.cruddemo.service.subject;

import com.ktoda.cruddemo.entity.subject.Subject;
import com.ktoda.cruddemo.repository.subject.SubjectRepository;
import com.ktoda.cruddemo.service.utility.CrudService;
import com.ktoda.cruddemo.service.utility.UniversityService;
import nl.flotsam.xeger.Xeger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService implements UniversityService, CrudService<Subject> {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public String generateSubjectCode(String name) {
        String regex = name.toUpperCase().charAt(0) + "[0-9]{3}";
        Xeger generator = new Xeger(regex);
        return generator.generate();
    }

    @Override
    public Subject save(Subject entity) {
        return subjectRepository.save(entity);
    }

    @Override
    public Iterable<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findById(Integer id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found!"));
    }

    @Override
    public void deleteById(Integer id) {
        subjectRepository.deleteById(id);
    }

    public Iterable<Subject> findAllSubjectsOfStudentById(Integer id) {
        return subjectRepository.findAllSubjectsOfStudentById(id);
    }

    public Iterable<Subject> findAllSubjectsOfStudentOrderBySubjectName() {
        return subjectRepository.findAllSubjectsOrderBySubjectName();
    }
}
