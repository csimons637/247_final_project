import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class deleteLater {
    public static Date parseDate1(String date) {
        try {
            return new SimpleDateFormat("MM/dd/yyyy").parse(date);
        } catch (ParseException e) {
            System.out.println("Sorry " + date + " is not parsable");
            return null;
        }
    }

    public String toString(Date date) {

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");

        return dateFormatter.format(date);

    }


public void run() {
        Date myDate = parseDate("2022-02-22");
    }

    /**
     * Converts a string date in the format yyyy-mm-dd to a java date
     *
     * @param date The string formatted date
     * @return The new date or null if the string is in the incorrect format
     */
    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }



}
