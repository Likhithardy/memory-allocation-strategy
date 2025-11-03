import java.util.Arrays;

public class Enumeration {
    public static void main(String[] args) {
        String str = "  Hello Java  ";
        String str2 = "hello java";

        // 1. Length
        System.out.println("length(): " + str.length());

        // 2. charAt
        System.out.println("charAt(2): " + str.charAt(2));

        // 3. toCharArray
        System.out.println("toCharArray(): " + Arrays.toString(str.toCharArray()));

        // 4. equals
        System.out.println("equals(str2): " + str.trim().equals(str2));

        // 5. equalsIgnoreCase
        System.out.println("equalsIgnoreCase(str2): " + str.trim().equalsIgnoreCase(str2));

        // 6. compareTo
        System.out.println("compareTo(str2): " + str.compareTo(str2));

        // 7. compareToIgnoreCase
        System.out.println("compareToIgnoreCase(str2): " + str.compareToIgnoreCase(str2));

        // 8. contains
        System.out.println("contains(\"Java\"): " + str.contains("Java"));

        // 9. indexOf
        System.out.println("indexOf(\"Java\"): " + str.indexOf("Java"));

        // 10. lastIndexOf
        System.out.println("lastIndexOf(\"a\"): " + str.lastIndexOf("a"));

        // 11. startsWith
        System.out.println("startsWith(\"  He\"): " + str.startsWith("  He"));

        // 12. endsWith
        System.out.println("endsWith(\"va  \"): " + str.endsWith("va  "));

        // 13. toUpperCase
        System.out.println("toUpperCase(): " + str.toUpperCase());

        // 14. toLowerCase
        System.out.println("toLowerCase(): " + str.toLowerCase());

        // 15. trim
        System.out.println("trim(): '" + str.trim() + "'");

        // 16. strip (Java 11+)
        System.out.println("strip(): '" + str.strip() + "'");

        // 17. replace
        System.out.println("replace('a','@'): " + str.replace('a', '@'));

        // 18. replaceAll (regex)
        System.out.println("replaceAll(\" \",\"-\"): " + str.replaceAll(" ", "-"));

        // 19. replaceFirst
        System.out.println("replaceFirst(\" \",\"*\"): " + str.replaceFirst(" ", "*"));

        // 20. substring(begin)
        System.out.println("substring(2): " + str.substring(2));

        // 21. substring(begin,end)
        System.out.println("substring(2,7): " + str.substring(2, 7));

        // 22. split
        System.out.println("split(\" \"): " + Arrays.toString(str.trim().split(" ")));

        // 23. join
        System.out.println("join(): " + String.join("-", "Java", "is", "cool"));

        // 24. isEmpty
        System.out.println("isEmpty(): " + str.isEmpty());

        // 25. isBlank (Java 11+)
        System.out.println("isBlank(): " + "   ".isBlank());

        // 26. valueOf
        System.out.println("valueOf(123): " + String.valueOf(123));

        // 27. intern
        System.out.println("intern(): " + str.intern());

        // 28. concat
        System.out.println("concat(): " + str.concat(" Rocks!"));

        // 29. matches (regex)
        System.out.println("matches(\".*Java.*\"): " + str.matches(".*Java.*"));

        // 30. format
        System.out.println("format(): " + String.format("I have %d apples", 5));

        // 31. repeat (Java 11+)
        System.out.println("repeat(): " + "Hi!".repeat(3));
    }
}
