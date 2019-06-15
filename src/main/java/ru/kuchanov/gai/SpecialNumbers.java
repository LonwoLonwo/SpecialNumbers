package ru.kuchanov.gai;

import java.util.*;

public class SpecialNumbers {

    public static void main(String[] args) {
        SpecialNumbers specialNumbers = new SpecialNumbers();
        Map<String, Map<String, List<String>>> allAutoSigns = specialNumbers.generateSigns();

       while (true){
           Scanner in = new Scanner(System.in);

           System.out.println("Enter region: ");
           String region = in.nextLine();
           System.out.println("Enter characters: ");
           String characters = in.nextLine();
           System.out.println("Enter numbers: ");
           String numbers = in.nextLine();

           System.out.println("You enter auto sign: " + numbers + characters + region);
           System.out.println("Start searching. Please, wait...");

           Map<String, List<String>> regionAutoSigns = allAutoSigns.get(region);
           if (regionAutoSigns != null) {
               List<String> integersForCharacters = regionAutoSigns.get(characters);
               if (integersForCharacters != null) {
                   if (integersForCharacters.indexOf(numbers) != -1) {
                       System.out.println("Number found!");
                   } else {
                       System.out.println("Numbers not found.");
                   }
               } else {
                   System.out.println("Characters not found.");
               }
           } else {
               System.out.println("Region not found.");
           }
       }
    }

    /**
     * without `ъ` и `ь`
     */
    private static final String alphabet = "абвгдежзийклмнопрстуфхцчшщыэюя";
    private static final List<String> CHARS = new ArrayList<>(Arrays.asList(alphabet.split("")));

    /**
     * regions from https://pddmaster.ru/avtomobili/kody-regionov-na-avtomobilnyx-nomerax.html#2
     */
    private static final List<String> REGIONS = new ArrayList<>(Arrays.asList("01, 02, 102, 03, 04, 05, 06, 07, 08, 09, 10, 11, 12, 13, 113, 14, 15, 16, 116, 716, 17, 18, 19, 21, 121, 22, 23, 93, 123, 24, 84, 88, 124, 25, 125, 26, 126, 27, 28, 29, 30, 31, 32, 33, 34, 134, 35, 36, 136, 37, 38, 85, 138, 39, 91, 40, 41, 42, 142, 43, 44, 45, 46, 47, 147, 48, 49, 50, 90, 150, 190, 750, 51, 52, 152, 53, 54, 154, 55, 56, 57, 58, 59, 81, 159, 60, 61, 161, 761, 62, 63, 163, 763, 64, 164, 65, 66, 96, 196, 67, 68, 69, 70, 71, 72, 73, 173, 74, 174, 75, 80, 76, 77, 97, 99, 177, 197, 199, 777, 799, 78, 98, 178, 198, 79, 82, 83, 86, 186, 87, 89, 92, 94, 95".split(", ")));

    static {
        REGIONS.sort(Comparator.naturalOrder());
    }

    @SuppressWarnings("WrapperTypeMayBePrimitive")
    private Map<String, Map<String, List<String>>> generateSigns() {
        List<String> allCharactersList = new ArrayList<>();
        for (String firstChar : CHARS) {
            for (String secondChar : CHARS) {
                for (String thirdChar : CHARS) {
                    allCharactersList.add(firstChar + secondChar + thirdChar);
                }
            }
        }

        List<String> allIntegersList = new ArrayList<>();
        for (Integer firstChar = 0; firstChar < 10; firstChar++) {
            for (Integer secondChar = 0; secondChar < 10; secondChar++) {
                for (Integer thirdChar = 0; thirdChar < 10; thirdChar++) {
                    allIntegersList.add(firstChar.toString() + secondChar.toString() + thirdChar.toString());
                }
            }
        }

        System.out.println("allCharactersList: " + allCharactersList.size());
        System.out.println("allIntegersList: " + allIntegersList.size());
        System.out.println("REGIONS: " + REGIONS.size());

        Map<String, Map<String, List<String>>> allAutoSigns = new TreeMap<>();

        Map<String, List<String>> charsToIntegers = new TreeMap<>();
        for (String chars : allCharactersList) {
            charsToIntegers.put(chars, allIntegersList);
        }

        for (String region : REGIONS) {
            allAutoSigns.put(region, charsToIntegers);
        }

        System.out.println(allAutoSigns.get("47").get("яяя").subList(150, 175));

        return allAutoSigns;
    }
}
