
import java.util.*;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static javafx.scene.input.KeyCode.T;


public class LambdasExamples {

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }


    public void doLambdas() {


        Match m1 = new Match(new Lco("a1", "b1"), "c1");
        Match m2 = new Match(new Lco("a1", "b1"), "c2");
        Match m3 = new Match(new Lco("a1", "b2"), "c3");
        Match m4 = new Match(new Lco("a1", "b1"), "c3");
        Match m5 = new Match(new Lco("a1", "b1"), "c3");

        List<Match> list = Arrays.asList(m1, m2, m3, m4, m5);


        Predicate<String> pp = s -> s.length() < 20;
        //Stream<Map.Entry<String, List<Match>>> stream = collect.entrySet().stream().;


        List<Match> matchStream = list.stream().filter(distinctByKey(a -> a.getVal3())).collect(Collectors.toList());


        Comparator<Person> cmpAge = (p1, p2) -> p2.getAge() - p1.getAge();
        Comparator<Person> cmpFirstName = (p1, p2) -> p2.getFirstName().compareTo(p1.getFirstName());
        Comparator<Person> cmpLastName = (p1, p2) -> p2.getLastName().compareTo(p1.getLastName());


        Function<Person, Integer> f1 = p -> p.getAge();
        Function<Person, String> f2 = p -> p.getLastName();
        Function<Person, String> f3 = p -> p.getFirstName();

        Comparator<Person> cmpPersonAge = Comparator.comparing(Person::getAge);
        Comparator<Person> cmpPersonLAstNAme = Comparator.comparing(Person::getLastName);


        //////////////////////////////////
        //merging maps

        Map<String, List<Person>> map1 = new HashMap<>();
        Map<String, List<Person>> map2 = new HashMap<>();

        map2.forEach(
                (key, value) ->
                        map1.merge(
                                key, value,
                                (existingPeople, newPeople) -> {
                                    existingPeople.addAll(newPeople);
                                    return existingPeople;
                                }
                        )
        );


        ////////////////////////////////////////////


//        Comparator<String> comparator = new Comparator<String>() {
//            public int compare(String s1, String o2) {
//                return Integer.compare(s1.length(), o2.length());
//            }
//        };
//
//
//
//        Comparator<String> comparing_strings = (s1, s2) -> {
//            System.out.println("comparing strings");
//            return Integer.compare(s1.length(), s2.length());
//        };

    }
}
