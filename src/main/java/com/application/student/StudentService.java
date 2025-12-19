package com.application.model.student;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    
    @Autowired
    private StudentRepository studentRepository;

        public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    
    public Optional<Student> getStudentById(Integer id) {
        
        return studentRepository.findById(id);
    }

    
    public Student createStudent(Student student) {
        
        return studentRepository.save(student);
    }

   
    public Student updateStudent(Integer id, Student studentDetails) {
       
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found for this id :: " + id));

        
        student.setCollegeID(studentDetails.getCollegeID());
        student.setFullName(studentDetails.getFullName());
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setGender(studentDetails.getGender());
        student.setCgpa(studentDetails.getCgpa());
        student.setResumeLink(studentDetails.getResumeLink());
        student.setEmail(studentDetails.getEmail());
        student.setPhoneNumber(studentDetails.getPhoneNumber());
        student.setRollNo(studentDetails.getRollNo());
        student.setCourseId(studentDetails.getCourseId());
        student.setBatch(studentDetails.getBatch());
        student.setStreamId(studentDetails.getStreamId());
        student.setTenthPercent(studentDetails.getTenthPercent());
        student.setTenthYearOfPassing(studentDetails.getTenthYearOfPassing());
        student.setTwelfthPercent(studentDetails.getTwelfthPercent());
        student.setTwelfthYearOfPassing(studentDetails.getTwelfthYearOfPassing());
        student.setCurrentBacklogs(studentDetails.getCurrentBacklogs());
        student.setAlternateEmail(studentDetails.getAlternateEmail());
        student.setAlternatePhone(studentDetails.getAlternatePhone());
        


        
        return studentRepository.save(student);
    }

    
    public void deleteStudent(Integer id) {
        
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found for this id :: " + id));

        studentRepository.delete(student);
    }}
