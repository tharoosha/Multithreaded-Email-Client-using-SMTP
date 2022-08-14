package RecipientCollection;

import RecipientFactoryPack.CloseOfficeFriends;
import RecipientFactoryPack.OfficialRecipient;
import RecipientFactoryPack.PersonalRecipient;
import RecipientFactoryPack.Recipient;

import java.util.ArrayList;
import java.util.List;

public class Collection implements ICollection{

    private static List<PersonalRecipient> personalRecipientsList = new ArrayList<PersonalRecipient>();
    private static List<CloseOfficeFriends> closeOfficeFriendsList = new ArrayList<CloseOfficeFriends>();
    private static List<OfficialRecipient> officialRecipientsList = new ArrayList<OfficialRecipient>();

    public void AddRecipient(String RecipientName,Recipient recipient){
        if (RecipientName.equals("PersonalRecipient")){
            personalRecipientsList.add((PersonalRecipient) recipient);
        }
        else if (RecipientName.equals("CloseOfficeFriends")){
            closeOfficeFriendsList.add((CloseOfficeFriends) recipient);
        }
        else if (RecipientName.equals("OfficialRecipient")){
            officialRecipientsList.add((OfficialRecipient) recipient);
        }
    }

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
