package net.home.qa.methods;

import net.home.qa.models.Person;
import org.json.JSONObject;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        String v1 = o1.getName().getFname().getNormal().toLowerCase().toString();
        String v2 = o2.getName().getFname().getNormal().toLowerCase().toString();
        return v1.compareTo(v2);
    }

}
