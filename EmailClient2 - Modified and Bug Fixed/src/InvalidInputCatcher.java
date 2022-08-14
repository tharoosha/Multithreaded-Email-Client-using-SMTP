import org.apache.commons.lang3.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InvalidInputCatcher {


    public static boolean InvalidInputCatcher(String input) throws InvalidInputException {

        DateValidatorUsingDateFormat dateFormat = new DateValidatorUsingDateFormat();

        String type = StringUtils.substringBefore(input, ":").trim().toLowerCase();
        //get the string after the recipient key-tag
        String PClient = StringUtils.substringAfter(input, ":").trim();
        //split the string in to the separate fields which is comma separated
        String[] Psplitted = PClient.split(",");

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if (type.equals("personal")){

            if (Psplitted.length == 4){
                Matcher matcher = pattern.matcher(Psplitted[2]);
                if (matcher.matches()){

                    if (dateFormat.isVaild(Psplitted[3])){
                        return true;
                    }
                }
                throw new InvalidInputException("Check the email again");
            }
            throw new InvalidInputException("Not necessary details provided");
        }
        else if (type.equals("official")){

            if (Psplitted.length == 4 && dateFormat.isVaild(Psplitted[3])){
                Matcher matcher = pattern.matcher(Psplitted[1]);
                if (matcher.matches()){
                    return true;
                }
                throw new InvalidInputException("Check the email again");
            }
            else if (Psplitted.length == 3){
                Matcher matcher = pattern.matcher(Psplitted[1]);
                if (matcher.matches()){
                    return true;
                }
                throw new InvalidInputException("Check the email again");
            }
           throw new InvalidInputException("Not necessary details provided");
        }
        else
            throw new InvalidInputException("Recipient formate does not match the given formate");

    }
}
