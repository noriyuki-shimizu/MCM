package source.usecases.converter;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Optional;

public class BuyDate {

    // sql.Date -> String
    public static String toString(Date date) {
        return Optional
                .ofNullable(date)
                .map(d -> {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    return dateFormat.format(d);
                })
                .orElse("");
    }

    // LocalDate -> sql.Date
    public static Date toSqlDate(String date) {
        return Optional
                .ofNullable(date)
                .map(Date::valueOf)
                .orElse(null);
    }

}
