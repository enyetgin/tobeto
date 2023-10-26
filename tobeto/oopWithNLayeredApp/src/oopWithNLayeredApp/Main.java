package oopWithNLayeredApp;

import oopWithNLayeredApp.business.ProductManager;
import oopWithNLayeredApp.core.logging.DatabaseLogger;
import oopWithNLayeredApp.core.logging.FileLogger;
import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.dataAccess.JdbcProductDao;
import oopWithNLayeredApp.dataAccess.HibernateProductDao;
import oopWithNLayeredApp.entities.Product;

public class Main {
    public static void main(String[] args) throws Exception {
        Product product1 = new Product(1, "Iphone 11", 10000);
        Product product2 = new Product(2, "Iphone 12", 19999);

        Logger[] loggers = {new DatabaseLogger(), new FileLogger()};
        ProductManager productManager = new ProductManager(new HibernateProductDao(), loggers);
        productManager.add(product1);
        //productManager.add(product2);

    }
}
