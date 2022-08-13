package EmailSender;

public abstract class Email {
    private String recipient;
    private String content;
    private String subject;

    public Email(String recipient,String subject,String content) {
        this.recipient = recipient;
        this.content = content;
        this.subject = subject;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getContent() {
        return content;
    }

    public String getSubject() {
        return subject;
    }
}
