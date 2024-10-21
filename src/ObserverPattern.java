//Create an Observer interface
interface Observer {
    void update(int temperature);
}

//Create a Subject class
class TemperatureSensor {
    private Observer observer1;
    private Observer observer2;

    public void setObserver1(Observer observer) {
        this.observer1 = observer;
    }

    public void setObserver2(Observer observer) {
        this.observer2 = observer;
    }

    public void updateTemperature(int temperature) {
        if (observer1 != null) {
            observer1.update(temperature);
        }
        if (observer2 != null) {
            observer2.update(temperature);
        }
    }
}

//Create concrete Observer classes
class DigitalDisplay implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Digital Display: Temperature updated to " + temperature + " degrees.");
    }
}

class AnalogDisplay implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Analog Display: Temperature updated to " + temperature + " degrees.");
    }
}

//Use the TemperatureSensor to manage and notify observers
public class ObserverPattern {
    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor();

        sensor.setObserver1(new DigitalDisplay());
        sensor.setObserver2(new AnalogDisplay());

        sensor.updateTemperature(25);
        sensor.updateTemperature(30);
    }
}
