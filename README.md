# Command line SMTP Email Client

This is a multithreaded email client that gives the basic functionalities of
•	Adding a new recipient through command line 
•	Sending emails using Javax.mail library and SMTP protocols
•	Print all recipient who have birthday on given particular date (date input through the command line)
•	Printing all the email on particular date with the time and subject 
•	Printing all the number of recipient maintain in the system

This simple application maintain a client list name ClientList.txt and load recipient data from that text file at the beginning of the program. After completion, 
it’s update the ClientList.txt. I send birthday emails automatically using a separate thread to avoid interfering with the application's main process. Before closing 
the application, the email object is serialized and stored in the SerializedFile.ser for further usage. I used some design patterns to deduce the coupling and increase 
the cohesion as well. Additionally, take care of a few custom exceptions that users frequently supply while entering data into the program.

![src](https://user-images.githubusercontent.com/75856174/184536317-767135f7-3be6-4c35-9b9d-19c01c6df767.png)
