package org.rastalion.formsubmission.bootstrap;

import org.rastalion.formsubmission.domain.Student;
import org.rastalion.formsubmission.service.StudentService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StudentBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final StudentService studentService;

    public StudentBootstrap(StudentService studentService) {
        this.studentService = studentService;
    }

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Student alex = new Student();
        alex.setName("Alexander");
        alex.setCity("Eeklo");
        alex.setGender("Male");
        alex.setGreatStudent(false);

        studentService.save(alex);

        Student sarah = new Student();
        sarah.setName("Sarah");
        sarah.setCity("Watervliet");
        sarah.setGender("Female");
        sarah.setGreatStudent(true);


        studentService.save(sarah);

    }
}
