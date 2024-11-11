import java.util.HashMap;
import java.util.Map;

public class CharFrequencyCounter {
    public Map<Character, Integer> calculateCharacterFrequency(String text) {
        Map<Character, Integer> charFrequency = new HashMap<>();

        for (char c : text.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }
        return charFrequency;
    }

    public double calculateAverageFrequency(Map<Character, Integer> charFrequency) {
        int totalFrequency = 0;
        int charCount = 0;

        for (int frequency : charFrequency.values()) {
            totalFrequency += frequency;
            charCount++;
        }
        return (double) totalFrequency / charCount;
    }

    public char findClosestCharacter(Map<Character, Integer> charFrequency, double targetFrequency) {
        char closestChar = 0;
        double minDifference = Double.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            double difference = Math.abs(entry.getValue() - targetFrequency);

            if (difference < minDifference) {
                minDifference = difference;
                closestChar = entry.getKey();
            }
        }
        return closestChar;
    }
}
