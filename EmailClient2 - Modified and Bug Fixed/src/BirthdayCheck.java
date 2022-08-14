import RecipientCollection.Collection;
import RecipientFactoryPack.CloseOfficeFriends;
import RecipientFactoryPack.PersonalRecipient;

public abstract class BirthdayCheck {
    private static String date;

    public static void setDate(String date) {
        BirthdayCheck.date = date;
    }

    public  static boolean check(){
        boolean status1 = false;
        boolean status2 = false;

        for (PersonalRecipient person : Collection.getPersonalRecipientsList()) {
            if (date.equals(person.getBirthday())) {
                System.out.println("Email Recipient: " + person.getEmail() + ", Subject: Happy Birthday");
                status1 = true;
            }
        }

        for (CloseOfficeFriends closeOfficeFriends : Collection.getCloseOfficeFriendsList()) {
            if (date.equals(closeOfficeFriends.getBirthday())) {
                System.out.println("Email Recipient: " + closeOfficeFriends.getEmail() + ", Subject: Happy Birthday");
                status2 = true;
            }
        }

        return status1 || status2;
    }

    public static void getBirthdayName(){
        boolean status1 = false;
        boolean status2 = false;


            for (PersonalRecipient person : Collection.getPersonalRecipientsList()) {
                if (date.equals(person.getBirthday())) {
                    System.out.println(person.getName());
                }else status1 = true;

            }

            for (CloseOfficeFriends closeOfficeFriends : Collection.getCloseOfficeFriendsList()) {
                if (date.equals(closeOfficeFriends.getBirthday())) {
                    System.out.println(closeOfficeFriends.getName());
                }else status2 = true;

            }

            if (!(status1 || status2)){
                System.out.println("No one has a birthday today");
            }
    }

}
