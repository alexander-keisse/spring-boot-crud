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

        studentService.save(alex);

        Student pearl = new Student();
        pearl.setName("Pearl");
        pearl.setCity("Brussel");

        studentService.save(pearl);

    }
}
