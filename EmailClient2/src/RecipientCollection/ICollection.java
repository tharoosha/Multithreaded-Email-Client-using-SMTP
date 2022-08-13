package RecipientCollection;

import RecipientFactoryPack.CloseOfficeFriends;
import RecipientFactoryPack.OfficialRecipient;
import RecipientFactoryPack.PersonalRecipient;
import RecipientFactoryPack.Recipient;

import java.util.ArrayList;
import java.util.List;

public interface ICollection {

    static List<PersonalRecipient> personalRecipientsList = new ArrayList<PersonalRecipient>();
    static List<CloseOfficeFriends> closeOfficeFriendsList = new ArrayList<CloseOfficeFriends>();
    static List<OfficialRecipient> officialRecipientsList = new ArrayList<OfficialRecipient>();

    public void AddRecipient(String RecipientName, Recipient recipient);

    public static List<PersonalRecipient> getPersonalRecipientsList() {
        return personalRecipientsList;
    }
    public static List<CloseOfficeFriends> getCloseOfficeFriendsList() {
        return closeOfficeFriendsList;
    }
    public static List<OfficialRecipient> getOfficialRecipientsList() {
        return officialRecipientsList;
    }
}
