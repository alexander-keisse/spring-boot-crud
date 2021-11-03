package org.rastalion.formsubmission.service;

import org.rastalion.formsubmission.domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    void save(Student student);

    Student findById(Long id);

    void deleteById(Long id);
}
