package oopWithNLayerdApp.business;

import oopWithNLayerdApp.Logging.Logger;
import oopWithNLayerdApp.dataAcces.HiberNateProductDao;
import oopWithNLayerdApp.dataAcces.ProductDao;
import oopWithNLayerdApp.entities.Product;

import java.util.List;

public class ProductManager {
    private ProductDao productDao;
    private Logger[] loggers;

    public ProductManager(ProductDao productDao, Logger[] loggers) {
        this.productDao = productDao;
        this.loggers = loggers;
    }

    public void add(Product product) throws Exception {
        //iş kuralları
        if (product.getUnitPrice() < 10) {
           throw new Exception("Ürün fiyatı 10dan küçük olamaz");
        }

        HiberNateProductDao productDao = new HiberNateProductDao();
        productDao.add(product);

        for (Logger logger : loggers) { //[db, mail]
            logger.log(product.getName());
        }
    }
}
