import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class Getter {

    public static void main(String[] args) {
        // Генерация числа
        int randomNumber = (int) (Math.random() * 100000);
        String apiUrl = "https://numbersapi.com/" + randomNumber ; //+ "/trivia";

        try {
            // Отправка GET-запроса
            String trivia = sendGetRequest(apiUrl);
            System.out.println(trivia);

            // Подсчёт частот символов
            Map<Character, Integer> charFrequency = calculateCharacterFrequency(trivia);

            // Вывод частот символов
            System.out.println("Частоты:");
            for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + " раза");
            }

            // Подсчёт средней частоты
            double averageFrequency = calculateAverageFrequency(charFrequency);

            System.out.println("Среднее значение частоты: " + averageFrequency);

            // Символ, ближайший к средней частоте
            char closestChar = findClosestCharacter(charFrequency, averageFrequency);
            System.out.println("Символ, наиболее близкий к средней частоте: " + closestChar +
                    " (Код UTF-8: " + (int) closestChar + ")");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    static String sendGetRequest(String apiUrl) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    static Map<Character, Integer> calculateCharacterFrequency(String text) {
        Map<Character, Integer> charFrequency = new HashMap<>();

        for (char c : text.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }
        return charFrequency;
    }

    static double calculateAverageFrequency(Map<Character, Integer> charFrequency) {
        int totalFrequency = 0;
        int charCount = 0;

        for (int frequency : charFrequency.values()) {
            totalFrequency += frequency;
            charCount++;
        }
        return (double) totalFrequency / charCount;
    }

    static char findClosestCharacter(Map<Character, Integer> charFrequency, double targetFrequency) {
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