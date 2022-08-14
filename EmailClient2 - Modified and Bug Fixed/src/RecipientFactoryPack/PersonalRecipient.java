package RecipientFactoryPack;

public class PersonalRecipient extends Recipient{
    private String nickname;
    private String birthday;


    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public String getBirthday() {
        return birthday;
    }
}
