package net.home.qa.methods;

import net.home.qa.models.Person;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class ComparatorByDate implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        try {
            Timestamp tm1 = convertDateToTimestamp(o1.getDate().getDigital_time());
            Timestamp tm2 = convertDateToTimestamp(o2.getDate().getDigital_time());
            return tm1.compareTo(tm2);
        } catch (ParseException e) {
            e.printStackTrace();
        }return 0;
    }
    public static Timestamp convertDateToTimestamp(String date) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date parsedDate = dateFormat.parse(date);
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
        return timestamp;
    }

}
