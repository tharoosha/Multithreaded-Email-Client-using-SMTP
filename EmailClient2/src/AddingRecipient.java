import javax.imageio.IIOException;
import java.io.*;

public class AddingRecipient {
    public AddingRecipient(String input) throws IOException {

        //create a file name ClientList
        File file = new File("ClientList.txt");

        String line =null;
        boolean rep = false;

        try{

            FileReader fReader = new FileReader(file);
            BufferedReader fileBuff = new BufferedReader(fReader);
            //check if the same line duplicate in the file
            while ((line = fileBuff.readLine()) != null){

                if (line.equals(input)){
                    rep = true;
                    break;
                }

            }
            fileBuff.close();
            fReader.close();
            //if input is not in the file append to the file within a newline
            if (!rep){
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(input);

                pr.close();
                br.close();
                fr.close();
            }
            System.out.println("Adding process end successfully");

        }
        catch (Exception e){
            //if the file is not exist run on creating file
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            pr.println(input);

            pr.close();
            br.close();
            fr.close();
            System.out.println("Adding process end successfully");
        }
    }
}
