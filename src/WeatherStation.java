//Make a WeatherStation that sends the data to our application

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);

        FunConditionsDisplay FunDisplay = new FunConditionsDisplay(weatherData);
        //ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.2f);

        //now lets remove an observer to see what happens
        weatherData.removeObserver(currentDisplay);
        weatherData.setMeasurements(78,90,29.2f);

        //now we make a new observer to see what happens
        new CurrentConditionsDisplay(weatherData);
        //we see we now display current conditions again (used to show how observers work in principle
        weatherData.setMeasurements(40,20,11.2f);
    }
}
