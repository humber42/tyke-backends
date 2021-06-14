package cu.edu.cujae.loginservice.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateUtils {

    public static long getTimeInMillisecondsFromLocalDate(){
        LocalDateTime dateTime = LocalDateTime.now();
        return Timestamp.valueOf(dateTime).getTime();
    }
}
