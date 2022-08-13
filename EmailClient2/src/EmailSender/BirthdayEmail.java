package EmailSender;

import javax.security.auth.Subject;

public abstract class BirthdayEmail extends Email{

    public BirthdayEmail(String recipient, String content) {
        super(recipient, "Happy Birthday",content);
    }


}
