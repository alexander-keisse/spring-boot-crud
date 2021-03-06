package org.rastalion.formsubmission.controllers;

import org.rastalion.formsubmission.domain.Student;
import org.rastalion.formsubmission.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "index";
    }

    @RequestMapping("/new")
    public String newStudentPage(Model model) {
        Student student = new Student();
        model.addAttribute(student);
        return "new_student";
    }

    @PostMapping("save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/";
    }

    @RequestMapping("edit/{id}")
    public String showEditStudentPage(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "edit_student";
    }

    @RequestMapping("delete/{id}")
    public String deleteStudentPage(@PathVariable(name = "id") Long id) {
        studentService.deleteById(id);
        return "redirect:/";
    }
}
