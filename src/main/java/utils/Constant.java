package utils;
import java.util.Random;

public class Constant {

    public final static String boardName = randomGenerator();
    public final static String list2 = randomGenerator();
    public final static String list1 = randomGenerator();


    private static String randomGenerator(){
        String characters= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i< 5 ; i++)
        {
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            stringBuilder.append(randomChar);
        }
        return String.valueOf(stringBuilder);
    }
}