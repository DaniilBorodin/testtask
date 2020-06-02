package net.home.qa;

import net.home.qa.methods.CountAndSort;
import net.home.qa.methods.RestApi;

import java.io.IOException;
import java.util.List;

public class JavaTasks {

    public static CountAndSort cs = new CountAndSort();
    public static RestApi restapi = new RestApi();

    public static void main(String[] args){

        List<String> list = List.of("Bob", "Alice", "Joe", "bob", "alice", "dEN");
        cs.countAndSortElements(list);
        try {
            restapi.getRequests(10);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
