package RecipientFactoryPack;

public class CloseOfficeFriends extends OfficialRecipient{
    private String birthday;

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

//    public CloseOfficeFriends(String designation, String name, String email, String birthday) {
//        super(designation, name, email);
//        this.birthday = birthday;
//    }

    public String getBirthday() {
        return birthday;
    }
}
