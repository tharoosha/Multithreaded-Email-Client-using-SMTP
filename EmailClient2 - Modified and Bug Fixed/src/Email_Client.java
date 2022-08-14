// your index number - 200682T

//import libraries


import EmailSender.Email;
import EmailSender.JavaMailUtil;
import EmailSender.NormalEmail;
import RecipientCollection.Collection;
import RecipientCollection.FileToAppLoader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Email_Client {


    public static void main(String[] args) throws InvalidInputException {

        //use thread to load file data into application without interrupting the main process
        FileToAppLoader fileToAppLoader = new FileToAppLoader();
        fileToAppLoader.FileToAppLoaderThread();

        Thread AutoWishSendThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BirthdayMailThread.AutoWishSender();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        AutoWishSendThread.start();
        try {
            AutoWishSendThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        DateValidatorUsingDateFormat dateFormat = new DateValidatorUsingDateFormat();

        SerializableHashMap serializableHashMap = new SerializableHashMap();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        Date date4 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String str = formatter.format(date4);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option type: \n"
                + "1 - Adding a new recipient\n"
                + "2 - Sending an email\n"
                + "3 - Printing out all the recipients who have birthdays\n"
                + "4 - Printing out details of all the emails sent\n"
                + "5 - Printing out the number of recipient objects in the application");

        int option = scanner.nextInt();


        switch (option) {
            case 1:
                // input format - Official: nimal,nimal@gmail.com,ceo
                // Use a single input to get all the details of a recipient
                // code to add a new recipient
                // store details in clientList.txt file
                // Hint: use methods for reading and writing files
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("input the details - format:Official: nimal,nimal@gmail.com,ceo");
                String input = scanner1.nextLine();
                if (InvalidInputCatcher.InvalidInputCatcher(input)) {
                    try {
                        AddingRecipient Recipient = new AddingRecipient(input);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                break;
            case 2:
                // input format - email, subject, content
                // code to send an email
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Input the details - format: email subject content");
                String email = scanner2.next();
                String subject = scanner2.next();
                String content = scanner2.nextLine().trim();

                Email email1 = new NormalEmail(email, subject, content);
                try {
                    System.out.println("Preparing to send email...");
                    JavaMailUtil.sendMail(email1.getRecipient(), email1.getSubject(), email1.getContent());
                    System.out.println("Message send successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                // input format - yyyy/MM/dd (ex: 2018/09/17)
                // code to print recipients who have birthdays on the given date
                Scanner scanner3 = new Scanner(System.in);
                System.out.println("input the date - format: yyyy/MM/dd (ex: 2018/09/17)");
                String date = scanner3.nextLine().trim();

                if (dateFormat.isVaild(date)) {
                    BirthdayCheck.setDate(date);
                    BirthdayCheck.getBirthdayName();
                }
                break;
            case 4:
                // input format - yyyy/MM/dd (ex: 2018/09/17)
                // code to print the details of all the emails sent on the input date
                Scanner scanner4 = new Scanner(System.in);
                System.out.println("input the date - format: yyyy/MM/dd (ex: 2018/09/17)");
                String date1 = scanner4.nextLine().trim();

                boolean status = false;
                if (dateFormat.isVaild(date1)) {
                    try {
                        HashMap<String, List<String>> map2 = serializableHashMap.Deserialization();
                        for (Map.Entry<String, List<String>> entry : map2.entrySet()) {
                            if (entry.getKey().equals(date1)) {
                                for (String recipient : entry.getValue()) {
                                    System.out.println(recipient);
                                }
                                status = true;
                            }
                        }
                    } catch (Exception e) {
                        BirthdayCheck.setDate(date1);
                        status = status || BirthdayCheck.check();
                    }
                }

                if (!status){
                    System.out.println("No email sent on the " + date1);
                }

                break;
            case 5:
                // code to print the number of recipient objects in the application
                int count = Collection.getPersonalRecipientsList().size() + Collection.getCloseOfficeFriendsList().size() + Collection.getOfficialRecipientsList().size();
                System.out.println("the number of recipients is " + count);
                //iterator pattern
                break;
        }

        try {
            HashMap<String, List<String>> map3 = serializableHashMap.Deserialization();
            for (Map.Entry<String, List<String>> entry : map3.entrySet()) {
                if (entry.getKey().equals(str)) {
                    List<String> newList = Stream.concat(entry.getValue().stream(), JavaMailUtil.getList().stream()).toList();
                    map.put(str, newList);
                    serializableHashMap.Serialization(map);
                }

            }
        }catch (NullPointerException e){
            map.put(str, JavaMailUtil.getList());
            serializableHashMap.Serialization(map);
        }
            // start email client
            // code to create objects for each recipient in clientList.txt
            // use necessary variables, methods and classes

            //ExecutorService executor = Executors.



    }
}

// create more classes needed for the implementation (remove the  public access modifier from classes when you submit your code)