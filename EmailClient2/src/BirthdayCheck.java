import RecipientCollection.Collection;
import RecipientFactoryPack.CloseOfficeFriends;
import RecipientFactoryPack.PersonalRecipient;

public abstract class BirthdayCheck {
    private static String date;

    public static void setDate(String date) {
        BirthdayCheck.date = date;
    }

    public static void check(){

        for (PersonalRecipient person : Collection.getPersonalRecipientsList()) {
            if (date.equals(person.getBirthday())) {
                System.out.println(person.getName());
            }
        }

        for (CloseOfficeFriends closeOfficeFriends : Collection.getCloseOfficeFriendsList()) {
            if (date.equals(closeOfficeFriends.getBirthday())) {
                System.out.println(closeOfficeFriends.getName());
            }
        }
    }

}
