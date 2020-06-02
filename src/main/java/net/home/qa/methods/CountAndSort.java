package net.home.qa.methods;

import java.util.*;
import java.util.stream.Collectors;

public class CountAndSort {

    public static void countAndSortElements( List<String> names) {


        Map<String, Long> modifyAndCountNames = names.stream()
                        .collect(Collectors.groupingBy((s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase()), Collectors.counting()));

        Map<String, Long> sortedNames = new LinkedHashMap<>();
        modifyAndCountNames.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(e -> sortedNames.put(e.getKey(), e.getValue()));

        sortedNames.forEach((k, v) -> System.out.println(k+" : "+v));
    }
}
