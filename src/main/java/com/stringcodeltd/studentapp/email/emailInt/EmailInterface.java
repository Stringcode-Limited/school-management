package com.stringcodeltd.studentapp.email.emailInt;

import com.stringcodeltd.studentapp.email.emailMod.EmailModel;

public interface EmailInterface {
    String SendMail(EmailModel details);
    String SendMailWithAttachment(EmailModel details);
}
