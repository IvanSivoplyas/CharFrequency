import java.io.IOException;
import java.util.Map;

public class Getter {

    public static void main(String[] args) {
        int randomNumber = (int) (Math.random() * 100000);
        String apiUrl = "https://numbersapi.com/" + randomNumber; // + "/trivia";

        Client client = new Client();
        CharFrequencyCounter frequencyCounter = new CharFrequencyCounter();

        try {
            String trivia = client.sendGetRequest(apiUrl);
            System.out.println(trivia);

            Map<Character, Integer> charFrequency = frequencyCounter.calculateCharacterFrequency(trivia);

            System.out.println("Частоты:");
            for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + " раза");
            }

            double averageFrequency = frequencyCounter.calculateAverageFrequency(charFrequency);
            System.out.println("Среднее значение частоты: " + averageFrequency);

            char closestChar = frequencyCounter.findClosestCharacter(charFrequency, averageFrequency);
            System.out.println("Символ, наиболее близкий к средней частоте: " + closestChar +
                    " (Код UTF-8: " + (int) closestChar + ")");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}