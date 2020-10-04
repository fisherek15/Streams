package best.programming;

import java.util.function.Function;

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
}
