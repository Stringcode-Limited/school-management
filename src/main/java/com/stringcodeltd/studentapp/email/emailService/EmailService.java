package com.stringcodeltd.studentapp.email.emailService;


import com.stringcodeltd.studentapp.email.emailInt.EmailInterface;
import com.stringcodeltd.studentapp.email.emailMod.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailService implements EmailInterface {
    @Autowired
    private JavaMailSender javamailsender;

    @Value("${spring.mail.username}")
    private String sender;

    public String SendMail(EmailModel emod) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(emod.getRecipient());
            mailMessage.setText(emod.getMessage());
            mailMessage.setSubject(emod.getSubject());
            javamailsender.send(mailMessage);
            return "Mail Has Been Sent Successfully...";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    public String SendMailWithAttachment(EmailModel emod) {
        MimeMessage mimeMessage = javamailsender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom("sender");
            mimeMessageHelper.setTo(emod.getRecipient());
            mimeMessageHelper.setText(emod.getMessage());
            mimeMessageHelper.setSubject(emod.getSubject());

            FileSystemResource file = new FileSystemResource(new File(emod.getAttachment()));
            mimeMessageHelper.addAttachment(file.getFilename(), file);
            javamailsender.send(mimeMessage);
            return "Mail sent Successfully";
        } catch (MessagingException e) {
            return "Error while sending mail!!!";
        }
    }
}
