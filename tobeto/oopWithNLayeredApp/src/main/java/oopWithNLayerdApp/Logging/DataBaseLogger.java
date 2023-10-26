package oopWithNLayerdApp.Logging;

public class DataBaseLogger implements Logger {
    @Override
    public void log(String data) {
        System.out.println("Veritabanına logladnı : " + data);
    }
}
