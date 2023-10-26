package oopWithNLayerdApp.dataAcces;

import oopWithNLayerdApp.entities.Product;

public class JdbcProductDao {
    public void add(Product product) {
        //sadece ve sadece db erişim kodları buraya yazılır... SQL
        System.out.println("JDBC İLE VERİ TABANINA EKLENDİ");
    }
}