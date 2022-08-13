import EmailSender.Email;
import EmailSender.JavaMailUtil;
import EmailSender.OfficialBMail;
import EmailSender.PersonalBMail;
import RecipientCollection.Collection;
import RecipientFactoryPack.CloseOfficeFriends;
import RecipientFactoryPack.PersonalRecipient;
import RecipientFactoryPack.Recipient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//import static RecipientCollection.Collection.personalRecipientsList;

public class BirthdayMailThread {
    //get the current date
    public static void AutoWishSender() throws Exception {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dft.format(now);
        //return date;



        for (PersonalRecipient personal : Collection.getPersonalRecipientsList()){
            Email email = new PersonalBMail(personal.getEmail());
            if (personal.getBirthday().equals(date)){
                JavaMailUtil.sendMail(email.getRecipient(),email.getSubject(),email.getContent());
            }
        }

        for (CloseOfficeFriends closeFriends : Collection.getCloseOfficeFriendsList() ){
            Email email = new OfficialBMail(closeFriends.getEmail());
            if (closeFriends.getBirthday().equals(date)){
                JavaMailUtil.sendMail(email.getRecipient(),email.getSubject(),email.getContent());
            }
        }
    }

}

