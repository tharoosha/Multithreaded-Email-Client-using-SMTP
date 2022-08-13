public class InvalidInputException extends Exception{
    public InvalidInputException(){
        super("Invalid Input. Please check the input again..");
    }

    public InvalidInputException(String message){
        super(message);
    }
}
