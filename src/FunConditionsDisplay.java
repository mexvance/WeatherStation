import java.lang.Math;

import static java.lang.Math.log;

//This is our Dewpint Display that we made for fun
public class FunConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private double dew = 0;
    private double dew2 = 0;
    static double a = 17.625;
    static double b = 243.04;

    private Subject weatherData;

    public FunConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        CalcDewPoint(temperature, humidity);
        display();
    }

    @Override
    public void display() {
        System.out.println("Dewpoint is at " + dew);
    }

    /**this function to dewpoint is an approximation of the real thing, it is slightly simplified but works for our purpose*/
    public double CalcDewPoint( float temp, float humid) {
        //calculate the dew point with a cool function that I found on the internets
        dew = b*((log((double)humid/100)+(a*temp/(b+temp)))
                /(a - log((double)humid/100)-(a*temp/(b+temp))));

        return dew;

    }

    /*
    //I left this as my actual code, I was having a hard time trying to come up with a testing harness for this without having extra dependencies, so I
    //left it with a variable you pass in to let it work with an outside test.
    public double CalcDewPoint() {

        //calculate the dew point with a cool function that I found on the internets
        dew = b*((log((double)humidity/100)+(a*temperature/(b+temperature)))
                /(a - log((double)humidity/100)-(a*temperature/(b+temperature))));
        return dew;

    }*/


}
