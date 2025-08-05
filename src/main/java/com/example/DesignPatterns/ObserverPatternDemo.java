package com.example.DesignPatterns;

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer { // update(float temperature) mà tất cả các thiết bị theo dõi nhiệt độ cần triển
                     // khai.
    void update(float temperature);
}

// Concrete Observer: PhoneDisplay: Nhận thông báo từ WeatherStation và cập nhật
// nhiệt độ lên giao diện của mình.
class PhoneDisplay implements Observer { // thiết bị theo dõi điệnt hoại
    @Override
    public void update(float temperature) {
        System.out.println("Phone Display: Current temperature is " + temperature + "°C");
    }
}

// Concrete Observer: TVDisplay: Nhận thông báo từ WeatherStation và cập nhật
// nhiệt độ lên giao diện của mình.
class TVDisplay implements Observer { // thiết bị theo dõi TV
    @Override
    public void update(float temperature) {
        System.out.println("TV Display: Current temperature is " + temperature + "°C");
    }
}

// Subject Interface: Giao diện Subject này định nghĩa các phương thức để thêm,
// xóa, và thông báo tất cả các Observer.
interface Subject {
    void registerObserver(Observer observer); // đăng ký mọt Observer mới

    void removeObserver(Observer observer); // hủy đăng ký Observer

    void notifyObservers(); // thông báo cho tất cả Observer
}

// Concrete Subject: WeatherStation
class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}

// Client code
public class ObserverPatternDemo {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        Observer phoneDisplay = new PhoneDisplay();
        Observer tvDisplay = new TVDisplay();

        weatherStation.registerObserver(phoneDisplay);
        weatherStation.registerObserver(tvDisplay);

        // Thay đổi nhiệt độ và thông báo cho các Observer
        weatherStation.setTemperature(25.0f); // Phone Display và TV Display sẽ hiển thị nhiệt độ mới
        weatherStation.setTemperature(30.0f); // Phone Display và TV Display sẽ cập nhật nhiệt độ mới
    }
}
