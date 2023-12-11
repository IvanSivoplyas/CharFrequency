import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetterTest {

    @Test
    void testSendGetRequest() throws IOException, InterruptedException {
        String apiUrl = "https://numbersapi.com/42/trivia";
        String result = Getter.sendGetRequest(apiUrl);
        assertNotNull(result);
    }

    @Test
    void testCalculateCharacterFrequency() {
        String text = "abc";
        Map<Character, Integer> charFrequency = Getter.calculateCharacterFrequency(text);
        assertEquals(1, charFrequency.get('a'));
        assertEquals(1, charFrequency.get('b'));
        assertEquals(1, charFrequency.get('c'));
    }

    @Test
    void testCalculateAverageFrequency() {
        Map<Character, Integer> charFrequency = Map.of('a', 1, 'b', 1, 'c', 1);
        double averageFrequency = Getter.calculateAverageFrequency(charFrequency);
        assertEquals(1.0, averageFrequency);
    }

    @Test
    void testFindClosestCharacter() {
        Map<Character, Integer> charFrequency = Map.of('a', 1, 'b', 1, 'c', 1);
        double targetFrequency = 1.0;
        char closestChar = Getter.findClosestCharacter(charFrequency, targetFrequency);
        assertEquals('c', closestChar);
    }
}
