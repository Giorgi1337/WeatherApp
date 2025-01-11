import java.io.IOException;
import java.util.Scanner;

public class WeatherApp {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        WeatherApi api = new WeatherApi();
        WeatherResponseParser parser = new WeatherResponseParser();

        while (true) {
            System.out.println("What city do you want to know the weather for? (Type 'exit' to quit): ");
            String city = scanner.nextLine();

            // Check if the user wants to exit the loop
            if ("exit".equalsIgnoreCase(city)) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            // Fetch and display the weather forecast
            String forecastString = api.getForecast(city);
            parser.parseAndPrint(forecastString);
        }
    }
}