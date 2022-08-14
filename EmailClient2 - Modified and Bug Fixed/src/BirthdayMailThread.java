import EmailSender.Email;
import EmailSender.JavaMailUtil;
import EmailSender.OfficialBMail;
import EmailSender.PersonalBMail;
import RecipientCollection.Collection;
import RecipientFactoryPack.CloseOfficeFriends;
import RecipientFactoryPack.PersonalRecipient;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class BirthdayMailThread {
    //get the current date
    public static void AutoWishSender() throws Exception {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = dft.format(now);
        //return date;


        SerializableHashMap serializableHashMap = new SerializableHashMap();
        HashMap<String, List<String>> map3 = serializableHashMap.Deserialization();

        Date date4 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String str = formatter.format(date4);

        try {
            for (Map.Entry<String, List<String>> entry : map3.entrySet()) {
                if (!(entry.getKey().equals(str))) {
                    personGet(date);
                }
            }
        }catch (Exception e){
            personGet(date);
        }

    }

    private static void personGet(String date) throws Exception {
        for (PersonalRecipient personal : Collection.getPersonalRecipientsList()) {
            Email email = new PersonalBMail(personal.getEmail());
            if (personal.getBirthday().equals(date)) {
                JavaMailUtil.sendMail(email.getRecipient(), email.getSubject(), email.getContent());
            }
        }

        for (CloseOfficeFriends closeFriends : Collection.getCloseOfficeFriendsList()) {
            Email email = new OfficialBMail(closeFriends.getEmail());
            if (closeFriends.getBirthday().equals(date)) {
                JavaMailUtil.sendMail(email.getRecipient(), email.getSubject(), email.getContent());
            }
        }
    }

}

