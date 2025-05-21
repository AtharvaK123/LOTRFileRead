import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MayTwetnty {
    TreeMap<String, Integer> charFrequency = new TreeMap<>();

    public MayTwetnty() {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            charFrequency.put(String.valueOf(ch), 0);
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("LOTR - Fellowship.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                for (char ch : line.toLowerCase().toCharArray()) {
                    String letter = String.valueOf(ch);
                    if (charFrequency.containsKey(letter)) {
                        charFrequency.put(letter, charFrequency.get(letter) + 1);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
        System.out.println("Letter Frequencies:");
        for (String key : charFrequency.keySet()) {
            System.out.println(key + ": " + charFrequency.get(key));
        }

        double total = 0;
        for (int value : charFrequency.values()) {
            total += value;
        }
        double average = total / 26;
        System.out.println("\nAverage Frequency: " + average);

        double sumSqDiffs = 0;
        for (int value : charFrequency.values()) {
            sumSqDiffs += Math.pow(value - average, 2);
        }
        double stdDev = Math.sqrt(sumSqDiffs / 26);
        System.out.println("Standard Deviation: " + stdDev);
        
        System.out.println("\nZ-Scores and Unusual Letters:");
        for (String key : charFrequency.keySet()) {
            int freq = charFrequency.get(key);
            double zScore = (freq - average) / stdDev;
            System.out.printf("%s: z = %.2f", key, zScore);

            if (Math.abs(zScore) > 2) {
                System.out.print(": UNUSUAL");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new MayTwetnty();
    }
}
