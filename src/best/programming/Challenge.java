package best.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Challenge {

    public static void main(String[] args) {

        // #1 Write the following anonymous class as a lambda expression
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for(String part : parts){
                    System.out.println(part);
                }
            }
        };

        Runnable runnable1 = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for(String part : parts){
                System.out.println(part);
            }
        };
        // End of #1

        // #4 Use the Supplier interface to write a text
        Supplier<String> iLoveJava = () -> "I love Java!";
        System.out.println(iLoveJava.get());
        // End of #4

        // #5 Sort and print the words with large first letter
        List<String> topName2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> firstUpperCaseList = new ArrayList<>();
        topName2015.forEach(name ->
                firstUpperCaseList.add(name.substring(0, 1).toUpperCase() + name.substring(1)));
        //firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
        //firstUpperCaseList.forEach(s -> System.out.println(s));
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);
        // End of #5

        // #6 Do the same like in #5 but use stream
            List<String> firstUpperCaseList2 = topName2015
                    .stream()
                    .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                    .sorted()
                    .collect(Collectors.toList());

            firstUpperCaseList2.forEach(System.out::println);
        // End of #6

        // #7 Print count of names that start with 'A' and do it with stream
        long countNamesStartWithA = topName2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .filter(s -> s.startsWith("A"))
                .count();
        System.out.println(countNamesStartWithA);
        // End of #7
    }

    // #2 Write the following methods as a lambda expression
    public static String everySecondChar(String source){
        StringBuilder returnVal = new StringBuilder();
        for(int i = 0; i < source.length(); i++){
            if(i % 2 == 1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    Function<String, String> lambdaEverySecondChar = s -> {
        StringBuilder returnVal = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(i % 2 == 1){
                returnVal.append(s.charAt(i));
            }
        }
        return returnVal.toString();
    };
    // End of #2

    // #3 Wrap lambdaEverySecondFunction in method
    public static String everySecondCharacter(Function<String, String> getEverySecondChar, String inputText){
        return getEverySecondChar.apply(inputText);
    }
    // End of #3
}
