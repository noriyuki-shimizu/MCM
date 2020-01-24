package source.usecases.converter;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;

public class BuyDate {

    // LocalDate -> sql.Date
    public static String toString(Date date) {
        if (Optional.ofNullable(date).isPresent()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(("yyyy-MM-dd"));
            return dateFormat.format(date);
        }
        return "";
    }

    // sql.Date -> String
    public static Date toSqlDate(LocalDate date) {
        if (Optional.ofNullable(date).isPresent()) {
            return Date.valueOf(date);
        }
        return null;
    }

}
