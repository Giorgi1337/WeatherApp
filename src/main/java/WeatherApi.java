import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class WeatherApi {
    private static final String API_KEY;
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast";

    // Static block to load the API key from the properties file
    static {
        String key;
        try {
            // Load properties from the classpath
            Properties properties = new Properties();
            try (var inputStream = WeatherApi.class.getClassLoader().getResourceAsStream("config.properties")) {
                if (inputStream == null) {
                    throw new IOException("config.properties file not found in classpath.");
                }

                properties.load(inputStream);
            }

            key = properties.getProperty("api.key"); // Read API key
            if (key == null || key.isEmpty()) {
                throw new IllegalStateException("API key for WeatherApi is missing in config.properties.");
            }
        } catch (IOException e) {
            System.err.println("Error reading API key from config.properties: " + e.getMessage());
            throw new RuntimeException("Failed to initialize WeatherApi: " + e.getMessage(), e);
        }
        API_KEY = key;
    }

    public String getForecast(String city) throws IOException {
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("City name cannot be null or empty.");
        }

        String apiUrl = BASE_URL + "?q=" + URLEncoder.encode(city, StandardCharsets.UTF_8) + "&appid=" + API_KEY + "&units=metric";
        URL url = new URL(apiUrl);

        // Open connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Check HTTP response code (handle non-200 responses)
        int responseCode = connection.getResponseCode();

        if (responseCode != 200) {
            // Read error stream from the connection and return the error message for debugging purposes
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            StringBuilder errorResponse = new StringBuilder();
            String line;
            while ((line = errorReader.readLine()) != null) {
                errorResponse.append(line);
            }
            errorReader.close();

            throw new IOException("Failed to fetch forecast: HTTP response code " + responseCode + " - " + errorResponse);
        }

        // Read response data
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return response.toString(); // Return raw JSON response
    }
}