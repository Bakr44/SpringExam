package com.example.springexam.Controller;

import com.example.springexam.ApiResponse.ApiResponse;
import com.example.springexam.Model.Student;
import com.example.springexam.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudent(){
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @PostMapping("/add")
     public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student Added Successfully"));
     }

     @PutMapping("/update/{id}")
     public ResponseEntity updateStudent(@RequestBody @Valid Student student,@PathVariable Integer id,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        boolean isUpdated=studentService.isUpdated(id,student);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Student Updated Successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Student Not Found!!"));
     }

     @DeleteMapping("/delete/{id}")
     public ResponseEntity deleteStudent(@PathVariable Integer id){
        boolean isDeleted=studentService.isDeleted(id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Student Deleted Successfully"));
        }
         return ResponseEntity.status(400).body(new ApiResponse("Student Not Found!!"));

     }

     @PostMapping("/getOneStudent/{id}")
     public ResponseEntity getStudentByID(@PathVariable Integer id){
        if (studentService.getStudentByID(id)==null){
            return ResponseEntity.status(400).body(new ApiResponse("Student Not Found!!"));
        }
        return ResponseEntity.status(200).body(studentService.getStudentByID(id));
     }

}
