package com.example.springexam.Controller;

import com.example.springexam.ApiResponse.ApiResponse;
import com.example.springexam.Model.Teacher;
import com.example.springexam.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllStudent(){
        return ResponseEntity.status(200).body(teacherService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher Added Successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@RequestBody @Valid Teacher teacher,@PathVariable Integer id,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        boolean isUpdated=teacherService.isUpdated(id,teacher);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Teacher Updated Successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Teacher Not Found!!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        boolean isDeleted=teacherService.isDeleted(id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Teacher Deleted Successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Teacher Not Found!!"));

    }

    @PostMapping("/getOneTeacher/{id}")
    public ResponseEntity getTeacherByID(@PathVariable Integer id){
        if (teacherService.getTeacherByID(id)==null){
            return ResponseEntity.status(400).body(new ApiResponse("Teacher Not Found!!"));
        }
        return ResponseEntity.status(200).body(teacherService.getTeacherByID(id));
    }


}
