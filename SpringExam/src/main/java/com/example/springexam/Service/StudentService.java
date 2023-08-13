package com.example.springexam.Service;

import com.example.springexam.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student>students=new ArrayList<>();

    public ArrayList<Student> getAllStudents(){
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public boolean isUpdated(Integer id,Student student){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)){
                students.set(i,student);
                return true;
            }
        }
        return false;
    }

    public boolean isDeleted(Integer id){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)){
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student getStudentByID(Integer id){
        for (Student student:students) {
            if (student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }
}
