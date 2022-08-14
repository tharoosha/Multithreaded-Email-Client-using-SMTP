package RecipientCollection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import RecipientFactoryPack.*;
import org.apache.commons.lang3.StringUtils;

public class FileToAppLoader {
    String line = null;
    FileReader fReader;

    //static List<PersonalRecipient> personalRecipientsList = new ArrayList<PersonalRecipient>();
    //static List<CloseOfficeFriends> closeOfficeFriendsList = new ArrayList<CloseOfficeFriends>();
    //static List<OfficialRecipient> officialRecipientsList = new ArrayList<OfficialRecipient>();

    public void FileToAppLoaderThread() {

        RecipientFactory recipientFactory = new RecipientFactory();
        Collection collection = new Collection();

        //reading from the file and add to the specific list
        {
            try {

                fReader = new FileReader("ClientList.txt");


                BufferedReader fileBuff = new BufferedReader(fReader);
                while ((line = fileBuff.readLine()) != null) {
                    //increment the count with the recipient

                    String RepType = StringUtils.substringBefore(line, ":");

                    //check if the key-tag belongs to Personal
                    if (RepType.equals("Personal")) {

                        //get the string after the recipient key-tag
                        String PClient = StringUtils.substringAfter(line, ":").trim();
                        //split the string in to the separate fields which is comma separated
                        String[] Psplitted = PClient.split(",");

                        PersonalRecipient personalRecipient = (PersonalRecipient) recipientFactory.getRecipient("PersonalRecipient");
                        personalRecipient.setName(Psplitted[0]);
                        personalRecipient.setEmail(Psplitted[2]);
                        personalRecipient.setBirthday(Psplitted[3]);
                        personalRecipient.setNickname(Psplitted[1]);

                        collection.AddRecipient("PersonalRecipient",personalRecipient);
                    }

                    //check if the key-tag belongs to Official
                    else {
                        //get the string after the recipient key-tag
                        String OClient = StringUtils.substringAfter(line, ":").trim();
                        //split the string in to the separate fields which is comma separated
                        String[] Osplitted = OClient.split(",");
                        //sorting out close friend and official member through the amount of fields

                        if (Osplitted.length == 4) {
                            CloseOfficeFriends closeOfficeFriends = (CloseOfficeFriends) recipientFactory.getRecipient("CloseOfficeFriends");
                            closeOfficeFriends.setName(Osplitted[0]);
                            closeOfficeFriends.setEmail(Osplitted[1]);
                            closeOfficeFriends.setBirthday(Osplitted[3]);
                            closeOfficeFriends.setDesignation(Osplitted[2]);

                            collection.AddRecipient("CloseOfficeFriends",closeOfficeFriends);

                        } else {
                            OfficialRecipient officialRecipient = (OfficialRecipient) recipientFactory.getRecipient("OfficialRecipient");

                            officialRecipient.setName(Osplitted[0]);
                            officialRecipient.setEmail(Osplitted[1]);
                            officialRecipient.setDesignation(Osplitted[2]);

                            collection.AddRecipient("OfficialRecipient",officialRecipient);

                        }
                    }

                }
                fileBuff.close();
                System.out.println("load the files successfully");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
