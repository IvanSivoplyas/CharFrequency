import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharFrequencyCounterTest {
    @Test
    void testCalculateCharacterFrequency() {
        CharFrequencyCounter counter = new CharFrequencyCounter();
        String text = "hello";

        Map<Character, Integer> expectedFrequency = new HashMap<>();
        expectedFrequency.put('h', 1);
        expectedFrequency.put('e', 1);
        expectedFrequency.put('l', 2);
        expectedFrequency.put('o', 1);

        Map<Character, Integer> actualFrequency = counter.calculateCharacterFrequency(text);
        assertEquals(expectedFrequency, actualFrequency);
    }

    @Test
    void testCalculateAverageFrequency() {
        CharFrequencyCounter calculator = new CharFrequencyCounter();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put('a', 2);
        frequencyMap.put('b', 3);
        frequencyMap.put('c', 5);

        double average = calculator.calculateAverageFrequency(frequencyMap);
        assertEquals(3.33, average, 0.01);
    }

    @Test
    void testFindClosestCharacter() {
        CharFrequencyCounter calculator = new CharFrequencyCounter();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put('a', 1);
        frequencyMap.put('b', 3);
        frequencyMap.put('c', 4);
        frequencyMap.put('d', 5);

        char closestChar = calculator.findClosestCharacter(frequencyMap, 3.5);
        assertEquals('b', closestChar);
    }
}
