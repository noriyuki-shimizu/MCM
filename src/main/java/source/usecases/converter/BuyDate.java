package source.usecases.converter;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Optional;

public class BuyDate {

    // sql.Date -> String
    public static String toString(Date date) {
        if (Optional.ofNullable(date).isPresent()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(("yyyy-MM-dd"));
            return dateFormat.format(date);
        }
        return "";
    }

    // LocalDate -> sql.Date
    public static Date toSqlDate(String date) {
        if (Optional.ofNullable(date).isPresent()) {
            return Date.valueOf(date);
        }
        return null;
    }

}
