package org.example;


public class Main
{
    public static void main(String[] args)
    {
        String mesaj = "vade oranı";
        //set value
        Product product1 = new Product();
        product1.setName("delonghi kahve makinesi");
        product1.setDiscount(7.0);
        product1.setUnitPrice(7500.0);
        product1.setUnitInStock(3);
        product1.setImageUrl("image1.jpg");

        Product product2 = new Product();
        product2.setName("smeg kahve makinesi");
        product2.setDiscount(7.0);
        product2.setUnitPrice(7500.0);
        product2.setUnitInStock(3);
        product2.setImageUrl("image2.jpg");

        Product product3 = new Product();
        product3.setName("kitchen aid kahve makinesi");
        product3.setDiscount(7.0);
        product3.setUnitPrice(7500.0);
        product3.setUnitInStock(3);
        product3.setImageUrl("image3.jpg");

        Product[] products = {product1, product2, product3};
        System.out.println("<ul>");
        for(Product product : products) {
            System.out.println("<li>" + product.getName() + "</li>");
        }
        System.out.println("</ul>");
        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setId(1);
        individualCustomer.setPhone("055534123431");
        individualCustomer.setCustomerNumber("12345");
        individualCustomer.setFirstName("Enes");
        individualCustomer.setLastName("Yetgin");

        CorporateCustomer corporateCustomer = new CorporateCustomer();
        corporateCustomer.setId(2);
        corporateCustomer.setCompanyName("Kodlama.io");
        corporateCustomer.setPhone("0555143214");
        corporateCustomer.setTaxNumber("11111111111");
        corporateCustomer.setCustomerNumber("54321");

        Customer[] customers = {individualCustomer, corporateCustomer};
    }
}