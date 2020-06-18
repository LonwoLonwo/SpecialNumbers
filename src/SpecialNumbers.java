import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SpecialNumbers
{
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] lettersOfNumber = {'A', 'B', 'C', 'E', 'H', 'K', 'M', 'O', 'P', 'T', 'Y', 'X'};

        ArrayList<String> moreLetters = new ArrayList<>();

        for(Character y : lettersOfNumber)
        {
            moreLetters.add(y.toString() + y.toString() + y.toString());
        }

        ArrayList<Integer> numbers = new ArrayList<>();

        for(int i = 1; i < 10; i++)
        {
            numbers.add(i*100 + i*10 + i);
        }

        ArrayList<String> stringNumbers = new ArrayList<>();
        for(Integer newInt : numbers)
        {
            stringNumbers.add(newInt.toString());
        }

        stringNumbers.add(0, "000");
        stringNumbers.add("001");
        stringNumbers.add("002");
        stringNumbers.add("003");
        stringNumbers.add("007");
        stringNumbers.add("123");
        stringNumbers.add("404");

        for(String x : stringNumbers) {
            System.out.println(x);
        }

        ArrayList<String> regions = new ArrayList<>(Arrays.asList("77", "97", "99", "177", "197", "199", "777", "799", "78",
                "98", "178", "198", "50", "90", "150", "190", "750", "47", "147"));
        regions.sort(Comparator.naturalOrder());

        ArrayList<String> allAutoSigns = new ArrayList<>();
        for (String threeBukvi: moreLetters) {
            for (String threeCifri: stringNumbers) {
                for (String region: regions) {
                    allAutoSigns.add(threeBukvi+threeCifri+region);
                }
            }
        }

        for(String o : allAutoSigns)
        {
            System.out.println(o);
        }

        System.out.println("New String");

    }
}
