package com.example.springexam.Service;

import com.example.springexam.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher>teachers=new ArrayList<>();

    public ArrayList<Teacher> getAllStudents(){
        return teachers;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public boolean isUpdated(Integer id,Teacher teacher){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)){
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }

    public boolean isDeleted(Integer id){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    public Teacher getTeacherByID(Integer id){
        for (Teacher teacher:teachers) {
            if (teacher.getId().equals(id)){
                return teacher;
            }
        }
        return null;
    }

}
