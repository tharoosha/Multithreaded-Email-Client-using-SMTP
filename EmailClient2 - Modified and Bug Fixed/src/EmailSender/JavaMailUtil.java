package EmailSender;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class JavaMailUtil{

    private static List<String> list = new ArrayList<String>();


    public static List<String> getList() {
        return list;
    }

    public static void sendMail(String recipient, String Subject, String Content) throws Exception {


        //System.out.println("Preparing to send email...");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");//mail.smtp.auth
        properties.put("mail.smtp.starttls.enable", "true");//mail.smtp.starttls enable
        properties.put("mail.smtp.host", "smtp.gmail.com");//mail.smtp.host - smtp.gmail.com
        properties.put("mail.smtp.port", "587");//mail.smtp.port - 587

        String myAccountEmail = "mailclientdemo7@gmail.com";
        String password = "lsnwkotpynqfipcq";


        Session session = Session.getInstance(properties, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail,password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail,recipient,Subject,Content);

        try{
            Transport.send(message);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");


        String s = "Email Recipient: " + recipient + ", Subject: " + Subject + ", Time: " + sdf.format(date);
        list.add(s);
    }



    private static Message prepareMessage(Session session, String myAccountEmail,String recipi,String Sub, String Text) {
        Message message = new MimeMessage(session);
        try {

            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recipi));
            message.setSubject(Sub);
            message.setText(Text);
        } catch (Exception ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
}
