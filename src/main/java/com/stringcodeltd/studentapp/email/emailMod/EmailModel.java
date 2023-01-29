package com.stringcodeltd.studentapp.email.emailMod;


import lombok.*;

@Data
@AllArgsConstructor

public class EmailModel {
        private String Recipient;
        private final String Subject;
        private final String Message;
       private String Attachment;
}
