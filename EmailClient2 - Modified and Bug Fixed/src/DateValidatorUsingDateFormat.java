import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidatorUsingDateFormat implements DateValidator{
    private String dateFormat = "yyyy/MM/dd";

    @Override
    public boolean isVaild(String dateStr) throws InvalidInputException {
        DateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            throw new InvalidInputException("Invalid date format");
        }
    }
}
