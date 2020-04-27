package source.usecases.converter;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Optional;

public class BuyDate {

    // sql.Date -> String
    public static String toString(final Date date) {
        return Optional
                .ofNullable(date)
                .map(d -> {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    return dateFormat.format(d);
                })
                .orElse("");
    }

    // LocalDate -> sql.Date
    public static Date toSqlDate(final String date) {
        return Optional
                .ofNullable(date)
                .map(Date::valueOf)
                .orElse(null);
    }

}
