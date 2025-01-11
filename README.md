# WeatherApp

WeatherApp is a lightweight Java-based console application that provides a 5-day weather forecast for any city using the [OpenWeather API](https://openweathermap.org/api).

---

## Features

- **Interactive Weather Fetching**: Retrieve accurate 5-day weather forecasts for cities in real-time.
- **Detailed Forecast Information**:
  - **Temperature** in Celsius
  - **Humidity** percentage
  - **Weather Descriptions** (e.g., "Clear Sky", "Few Clouds")
  - **Timestamps** of forecasted intervals
- **Simple Console Interface**: Type the city name or exit anytime by typing `exit`.

---

## Prerequisites

To run WeatherApp, ensure you have the following:

1. **Java 17 or later** installed on your system.
2. A valid **OpenWeather API key**. Sign up at [OpenWeather API](https://openweathermap.org/api) to obtain one.
3. Create a configuration file `config.properties` in your `resources` folder with the following content:
   ```
   api.key=YOUR_OPENWEATHER_API_KEY
   ```
   Replace `YOUR_OPENWEATHER_API_KEY` with the actual API key you obtained from OpenWeather.

---

## How It Works

- When you run the application, it will prompt you to enter the name of a city.
- The application sends a request to the OpenWeather API to fetch the 5-day weather forecast for the entered city.
- The raw JSON response is processed to extract and display temperatures, humidity, weather descriptions, and timestamps in a human-readable format.
- If you enter an invalid or non-existent city name, the program will notify you of the error and prompt again.

---

## Example Usage

```text
What city do you want to know the weather for? (Type 'exit' to quit): 
Tbilisi
Weather Forecast:
2025-01-11 21:00:00 – Temperature: 3.85°C, Humidity: 63%, Description: few clouds
2025-01-12 00:00:00 – Temperature: 4.49°C, Humidity: 63%, Description: scattered clouds
2025-01-12 03:00:00 – Temperature: 4.78°C, Humidity: 59%, Description: overcast clouds
2025-01-12 06:00:00 – Temperature: 5.85°C, Humidity: 52%, Description: overcast clouds
2025-01-12 09:00:00 – Temperature: 9.89°C, Humidity: 38%, Description: overcast clouds
...

What city do you want to know the weather for? (Type 'exit' to quit): 
exit
Exiting the program. Goodbye!
```

---

## Troubleshooting

- **API Key Missing or Invalid**:
  - Ensure you correctly added your API key to the `config.properties` file under the key `api.key`.
  - Verify your API key is valid and activated on OpenWeather.
- **Network or Connection Errors**:
  - Ensure you are connected to the internet.
  - Make sure the OpenWeather API service is reachable.
- **City Not Found**:
  - Use a valid, correctly spelled city name. For example: "New York" instead of "NY".
- **Error Messages**:
  - If an error occurs during the HTTP request, the program will display a detailed error message for troubleshooting.

---

Enjoy using WeatherApp! 🌦️
