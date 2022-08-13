package RecipientFactoryPack;

public class OfficialRecipient extends Recipient{
    private String designation;

//    public OfficialRecipient(String designation, String name, String email) {
//        super(email,name);
//        this.designation = designation;
//    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
}
