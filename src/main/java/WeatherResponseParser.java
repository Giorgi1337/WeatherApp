import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherResponseParser {

    public void parseAndPrint(String jsonResponse) {
        // Parse JSON response
        JSONObject response = new JSONObject(jsonResponse); // Assumes JSON library is available
        JSONArray list = response.getJSONArray("list");

        System.out.println("Weather Forecast:");
        for (int i = 0; i < list.length(); i++) {
            JSONObject forecast = list.getJSONObject(i);
            String dateTime = forecast.getString("dt_txt");
            JSONObject main = forecast.getJSONObject("main");
            Double temp = main.getDouble("temp");
            int humidity = forecast.getJSONObject("main").getInt("humidity");
            String description = forecast.getJSONArray("weather").getJSONObject(0).getString("description");

            System.out.printf("%s – Temperature: %.2f°C, Humidity: %d%%, Description: %s%n", dateTime, temp, humidity, description);
        }
    }
}