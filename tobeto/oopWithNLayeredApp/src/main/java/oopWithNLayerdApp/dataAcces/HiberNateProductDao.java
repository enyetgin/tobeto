package oopWithNLayerdApp.dataAcces;

import oopWithNLayerdApp.entities.Product;

public class HiberNateProductDao {
    public void add(Product product) {
    //sadece ve sadece db erişim kodları buraya yazılır... SQL
        System.out.println("HİBERNATE İLE VERİ TABANINA EKLENDİ");
    }
}
