import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class CombinedTasks {
    public static void main(String[] args) {
        linkedHashsetOps();
        treesetPrinter("words.txt");
        formatAndParseNumbers();
    }

    private static void linkedHashsetOps() {
        Set<String> set1 = new LinkedHashSet<>(Set.of("George", "Jim", "John", "Blake", "Kevin", "Michael"));
        Set<String> set2 = new LinkedHashSet<>(Set.of("George", "Katie", "Kevin", "Michelle", "Ryan"));

        Set<String> union = new LinkedHashSet<>(set1);
        union.addAll(set2);

        Set<String> difference = new LinkedHashSet<>(set1);
        difference.removeAll(set2);

        Set<String> intersection = new LinkedHashSet<>(set1);
        intersection.retainAll(set2);

        System.out.println("Union: " + union);
        System.out.println("Difference: " + difference);
        System.out.println("Intersection: " + intersection);
    }

    private static void treesetPrinter(String filePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            TreeSet<String> words = new TreeSet<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] wordLine = line.split("\\s+");
                for (String word : wordLine) {
                    words.add(word);
                }
            }
            br.close();

            System.out.println("\nNonduplicate words in ascending order:");
            words.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void formatAndParseNumbers() {
        double number = 12345.678;

        // UK 
        NumberFormat nfUK = NumberFormat.getNumberInstance(Locale.UK);
        nfUK.setMaximumFractionDigits(2);
        System.out.println("\nFormatted in UK Locale: " + nfUK.format(number));

        // US 
        NumberFormat nfUS = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Formatted in US Currency: " + nfUS.format(number));

        // Parsing
        try {
            Number parsedNumber = nfUK.parse("12,345.678");
            System.out.println("Parsed Number: " + parsedNumber);
        } catch (ParseException e) {
            System.out.println("Error parsing number: " + e.getMessage());
        }
    }
}