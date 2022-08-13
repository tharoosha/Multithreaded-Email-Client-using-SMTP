import EmailSender.JavaMailUtil;

import java.io.*;
import java.util.HashMap;

public  class SerializableHashMap extends JavaMailUtil implements Serializable {
    HashMap<String,String> email = new HashMap<>();

    public SerializableHashMap() {
        this.email = getEmail();
    }

    public void Serialization(){
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream("SerializedFile.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(email);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
    }

    public HashMap<String,String> Deserialization(){
        HashMap<String,String> mail;

        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("SerializedFile.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            mail = (HashMap<String,String>)in.readObject();

            in.close();
            file.close();

            //System.out.println("Object has been deserialized ");
            return mail;
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        return null;
    }
}
