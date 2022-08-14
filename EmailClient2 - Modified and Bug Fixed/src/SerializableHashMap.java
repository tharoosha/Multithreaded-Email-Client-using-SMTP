import java.io.*;
import java.util.HashMap;
import java.util.List;

public class SerializableHashMap implements Serializable {


    public void Serialization(HashMap<String,List<String>> map ){

        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream("SerializedFile.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(map);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
    }




    public HashMap<String, List<String>> Deserialization(){

        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("SerializedFile.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            Object object = in.readObject();
            HashMap<String,List<String>> mail = (HashMap<String,List<String>>) object;

            in.close();
            file.close();

            //System.out.println("Object has been deserialized ");
            return mail;
        }

        catch(Exception ex){

        }

        return null;
    }
}
