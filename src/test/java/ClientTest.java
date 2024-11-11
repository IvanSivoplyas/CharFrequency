import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    @Test
    void testSendGetRequest() {
        Client client = new Client();
        int randomNumber = (int) (Math.random() * 100000);
        String apiUrl = "https://numbersapi.com/" + randomNumber;

        try {
            String response = client.sendGetRequest(apiUrl);
            assertNotNull(response);
        } catch (IOException | InterruptedException e) {
            fail("Exception should not have been thrown");
        }
    }
}
