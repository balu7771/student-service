package com.maveric.student.service;

import com.maveric.student.model.Student;
import com.maveric.student.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void getAllStudents() {
        Student student1 = new Student();
        student1.setStudentId("1");
        student1.setName("Shan");
        
        Student student2 = new Student();
        student2.setStudentId("2");
        student2.setName("Balaji");
        
        List<Student> mockStudents = Arrays.asList(student1, student2);
        when(studentRepository.findAll()).thenReturn(mockStudents);
        
        List<Student> result = studentService.getAllStudents();
        
        assertEquals(2, result.size());
        verify(studentRepository).findAll();
    }

    @Test
    void createStudent() {
        Student student = new Student();
        student.setStudentId("1");
        student.setName("shan");
        student.setContact("9840142282");
        student.setEmail("eakshan@gmail.com");
        student.setLocation("Bangalore");

        when(studentRepository.save(student)).thenReturn(student);
        
        Object result = studentService.createStudent(student);
        
        assertNotNull(result);
        verify(studentRepository).save(student);
    }
}