// your index number - 200682T

//import libraries


import EmailSender.Email;
import EmailSender.JavaMailUtil;
import EmailSender.NormalEmail;
import RecipientCollection.Collection;
import RecipientCollection.FileToAppLoader;

import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.Map;
import java.util.Scanner;

public class Email_Client {


    public static void main(String[] args) throws InvalidInputException{

        //use thread to load file data into application without interrupting the main process
        FileToAppLoader fileToAppLoader = new FileToAppLoader();
        fileToAppLoader.FileToAppLoaderThread();;
//        Thread FileloaderThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                fileToAppLoader.FileToAppLoaderThread();
//            }
//        });

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


//        FileloaderThread.start();
//        FileloaderThread.join();

        AutoWishSendThread.start();
//        try {
//            AutoWishSendThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        SerializableHashMap serializableHashMap = new SerializableHashMap();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option type: \n"
                + "1 - Adding a new recipient\n"
                + "2 - Sending an email\n"
                + "3 - Printing out all the recipients who have birthdays\n"
                + "4 - Printing out details of all the emails sent\n"
                + "5 - Printing out the number of recipient objects in the application");

        int option = scanner.nextInt();


            switch(option) {
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
                    //                Email email1 = MailSender.MainChooser("NormalEmail");
                    //                email1.sendEmail(email,"NormalEmail",subject,content);
                    break;
                case 3:
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    // code to print recipients who have birthdays on the given date
                    Scanner scanner3 = new Scanner(System.in);
                    String date = scanner3.nextLine().trim();
                    DateValidator validator = new DateValidatorUsingDateFormat("MM/dd/yyyy");
                    if (validator.isValid(date)){
                        BirthdayCheck.setDate(date);
                        BirthdayCheck.check();
                    }

                    //iterator pattern
                    break;
                case 4:
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    // code to print the details of all the emails sent on the input date
                    Scanner scanner4 = new Scanner(System.in);
                    String date1 = scanner4.nextLine().trim();
                    DateValidator validator1 = new DateValidatorUsingDateFormat("MM/dd/yyyy");
                    if (validator1.isValid(date1)){
                        BirthdayCheck.setDate(date1);
                        BirthdayCheck.check();
                    }
                    //printing email after the App start
                    for (Map.Entry<String, String> entry : JavaMailUtil.getEmail().entrySet()) {
                        if (entry.getKey().equals(date1)) {
                            System.out.println("send a email to " + entry.getValue());
                        }
                    }


                    //printing past store email
                    try {
                        for (Map.Entry<String, String> entry : serializableHashMap.Deserialization().entrySet()) {
                            if (entry.getKey().equals(date1)) {
                                System.out.println("send a email to " + entry.getValue());
                            }
                        }
                    }catch (NullPointerException e){return;}

                    //printing emails
                    break;
                case 5:
                    // code to print the number of recipient objects in the application
                    int count = Collection.getPersonalRecipientsList().size() + Collection.getCloseOfficeFriendsList().size() + Collection.getOfficialRecipientsList().size();
                    System.out.println("the number of recipients is " + count);
                    //iterator pattern
                    break;

            }

        serializableHashMap.Serialization();
        // start email client
        // code to create objects for each recipient in clientList.txt
        // use necessary variables, methods and classes

    }
}

// create more classes needed for the implementation (remove the  public access modifier from classes when you submit your code)