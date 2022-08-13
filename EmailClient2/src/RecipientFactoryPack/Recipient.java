package RecipientFactoryPack;

public abstract class Recipient {
    private String email;
    private String name;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

//    public Recipient(String email, String name) {
//        this.email = email;
//        this.name = name;
//    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}
