package oopWithNLayerdApp;

import oopWithNLayerdApp.Logging.DataBaseLogger;
import oopWithNLayerdApp.Logging.FileLogger;
import oopWithNLayerdApp.Logging.Logger;
import oopWithNLayerdApp.business.ProductManager;
import oopWithNLayerdApp.dataAcces.HiberNateProductDao;
import oopWithNLayerdApp.dataAcces.ProductDao;
import oopWithNLayerdApp.entities.Product;

public class Main {
    public static void main(String[] args) throws Exception {
        Product product1  = new Product(1, "Iphone XR", 9000);

        Logger[] loggers = {new DataBaseLogger()};

        ProductManager productManager = (new HiberNateProductDao(), loggers);
        productManager.add(product1);

    }
}