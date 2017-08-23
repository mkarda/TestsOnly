import java.io.File;
import java.io.FileFilter;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws InterruptedException {

//        FileFilter fileFilter = new FileFilter() {
//            @Override
//            public boolean accept(File file) {
//                return file.getName().endsWith(".txt");
//            }
//        };

        //DoExamples();
        LambdasExamples l = new LambdasExamples();
        l.doLambdas();





    }

    private static void DoExamples() throws InterruptedException {
        FileFilter filterLambda = (File file) -> file.getName().endsWith(".java");


        File dir = new File("d:/tmp");

        File[] files = dir.listFiles(filterLambda);

        for (File f : files) {
            System.out.println(f);
        }


        List<Integer> ll = Arrays.asList(5,4,4);

        String collect = ll.stream().map(s -> s.toString()).collect(Collectors.joining("-"));

        System.out.println(collect);

        System.out.println("----------");


        runRunnableExample();
        compareExample();
        predicates();
        foreach();

        StreamExamples.doStaticStuff();
    }

    private static void foreach() {
        List<String> strings = Arrays.asList("one", "two", "three", "four","five");

        List<String> results = new ArrayList<>();

        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = results::add;

        strings.forEach(c1.andThen(c2));

        System.out.println("size: " + results.size());




    }

    private static void predicates() {
        Predicate<String> p1 = s -> s.length() < 20;
        Predicate<String> p2 = s -> s.length() > 20;

        Predicate<String> p3 = p1.and(p2);
        boolean siema = p3.test("siema");
        System.out.println(siema);

    }

    private static void compareExample() {

        Comparator<String> compare = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };

//        Comparator<String> compLambda = Comparator.comparingInt(String::length);
//
//        //List<String> list = new Arrays.asList("***", "**", "****", "*");
//        String[] ss = {"***", "**", "****", "*"};
//        List<String> list = Arrays.asList(ss);
//        Collections.sort(list, compLambda);
//
//        for (String s :list) {
//            System.out.println(s);
//        }
//
//        // OR
//
//        list.forEach(System.out::println);



    }




    static void runRunnableExample() throws InterruptedException {

        RunnableExample re = new RunnableExample();
        Runnable runnable = re.runnable;

        Runnable runnabvleLambda = () ->
        {

            for (int i = 0; i < 3; i++) {
                System.out.println(
                        "Hello world from thrrad [" +
                                Thread.currentThread().getName() +
                                "]");

            }
        };


        Thread t = new Thread(runnabvleLambda);
        t.start();
        t.join();

    }

}
;