package RecipientFactoryPack;

public class RecipientFactory {

    public RecipientFactory() {
    }

    public Object getRecipient(String RecipientType){
        if (RecipientType == null){
            return null;
        }
        if (RecipientType.equalsIgnoreCase("PersonalRecipient")){
            return new PersonalRecipient();
        }
        else if (RecipientType.equalsIgnoreCase("CloseOfficeFriends")){

            return new CloseOfficeFriends();
        }
        else if (RecipientType.equalsIgnoreCase("OfficialRecipient")){
            return new OfficialRecipient();
        }

        return null;
    }
}
