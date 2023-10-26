package oopWithNLayeredApp.dataAccess;

import oopWithNLayeredApp.entities.Product;

public class JdbcProductDao implements ProductDao {
    public void add(Product product)
    {
        //Sql komutları
        System.out.println("Jdbc ile veritabanına eklendi.");
    }
    //Polymorphism

}
