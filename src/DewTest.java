//Test the dewpoint calculation for blaring errors
import java.lang.Double;
public class DewTest {
    private static FunConditionsDisplay FunDisplay;
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        FunDisplay = new FunConditionsDisplay(weatherData);
        Double dew = FunDisplay.CalcDewPoint(80,65);
        if ( Math.floor(dew * 100) / 100 != 69.83){
            System.out.println("DEWPOINT IS BROKE");
        }
        else
        {
            System.out.println("ALL IS GOOD");
        }
    }
}
