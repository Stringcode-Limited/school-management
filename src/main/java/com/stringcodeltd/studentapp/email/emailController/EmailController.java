package com.stringcodeltd.studentapp.email.emailController;

import com.stringcodeltd.studentapp.dao.StudentRepository;
import com.stringcodeltd.studentapp.email.emailMod.EmailModel;
import com.stringcodeltd.studentapp.email.emailService.EmailService;
import com.stringcodeltd.studentapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/students")
public class EmailController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private EmailService emailService;
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/sendMail/{id}")
    public String sendMail(@RequestBody EmailModel emod,@PathVariable("id") long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            emod.setRecipient(student.get().getFirstName());
//            THE EMAIL HAS NOT BEEN SET YET THAT IS WHY THERE IS (student.get().getFirstname instead of .getEmail
        }
        else {
            return  "User not found";
        }
        System.out.println(emod);
        String mail = emailService.SendMail(emod);
        return mail;
    }

    @PostMapping("/sendMailWithAttachment/{id}")
    public String sendMailWithAttachment(@RequestPart("json") EmailModel emod,
                                         @RequestPart("file") MultipartFile file,@PathVariable("id")long id) {
        try {
            Optional<Student> student = studentRepository.findById(id);
            if(student.isPresent()){
                emod.setRecipient(student.get().getFirstName());
//                  Email Has Not Yet Been Added
            }
            else {
                return  "User not found";
            }
            String dir = request.getServletContext().getRealPath("uploads/");
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
            File image = new File(dir+date+file.getOriginalFilename());
            image.createNewFile();
            file.transferTo(image);
            emod.setAttachment(image.getAbsolutePath());
        } catch (IOException e) {
            return e.getMessage();
        }

        String mail = emailService.SendMailWithAttachment(emod);
        return mail;
    }

}
