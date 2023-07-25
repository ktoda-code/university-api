package com.ktoda.cruddemo.service.teacher;

import com.ktoda.cruddemo.entity.student.Student;
import com.ktoda.cruddemo.entity.teacher.Teacher;
import com.ktoda.cruddemo.exception.student.StudentAlreadyExistsException;
import com.ktoda.cruddemo.exception.student.StudentNotFoundException;
import com.ktoda.cruddemo.exception.student.StudentRequestException;
import com.ktoda.cruddemo.exception.teacher.TeacherAlreadyExistsException;
import com.ktoda.cruddemo.exception.teacher.TeacherNotFoundException;
import com.ktoda.cruddemo.exception.teacher.TeacherRequestException;
import com.ktoda.cruddemo.repository.teacher.TeacherRepository;
import com.ktoda.cruddemo.service.utility.CrudService;
import com.ktoda.cruddemo.service.utility.UserService;
import nl.flotsam.xeger.Xeger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService implements UserService, CrudService<Teacher> {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public String generateUsername(String firstName) {
        String regex = "[a-zA-Z0-9]{4}" + firstName.toLowerCase().substring(0, 4);
        Xeger generator = new Xeger(regex);
        return generator.generate();
    }

    @Override
    public Teacher save(Teacher entity) {
        try {
            if (findTeacherById(entity.getId()).getId().equals(entity.getId())) {
                throw new TeacherAlreadyExistsException("Student already exists!");
            }
        } catch (TeacherNotFoundException e) {
            return teacherRepository.save(entity);
        }

        throw new TeacherRequestException("Error creating teacher. Unable to determine the cause.");
    }

    private Teacher findTeacherById(Integer id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException("Teacher not found!"));
    }

    @Override
    public Iterable<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(Integer id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException("Teacher not found!"));
    }

    @Override
    public void deleteById(Integer id) {
        teacherRepository.deleteById(id);
    }
}
