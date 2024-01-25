package inheritance.webshop;

import java.util.ArrayList;
import java.util.List;

public class WebShop {

    /**
     * After completing the previous exercises, you should have a working Product
     * class and a working Vehicle class. As the Vehicle class inherits the Product
     * class, you can use it anywhere where a Product object is expected. Thus, you
     * can create a list of products that contains both products and vehicles.
     *
     * Implement this method so that it returns a new list, that includes all the
     * different types of products from the given lists. The method should return a
     * single list and not modify any of the given lists.
     *
     * @param mugs   a list of mugs
     * @param shirts a list of shirts
     * @param cars   a list of cars
     * @param bikes  a list of bikes
     * @return a list of all the products in the same order as the given lists
     */
    public List<Product> combineListsOfProducts(List<Product> mugs, List<Product> shirts,
            List<Vehicle> cars, List<Vehicle> bikes) {
            
            List<Product> palautus = new ArrayList<>();
            palautus.addAll(mugs);
            palautus.addAll(shirts);
            palautus.addAll(cars);
            palautus.addAll(bikes);
            return palautus;    
    }

    /**
     * As Vehicle, Ticket and Apartment objects can be used anywhere where a Product
     * is expected, you can't always be sure what kind of object you are dealing
     * with. Therefore it is sometimes necessary to check the type of the object.
     *
     * Complete this method so that it checks if the given product is actually a
     * Vehicle. If the given product is a Vehicle, the method should return true.
     *
     * @param obj the object to check
     * @return true if the given object is a Vehicle, false otherwise
     */
    public boolean isVehicle(Object obj) {

        return obj instanceof Vehicle;

    }

    /**
     * Like the previous method, this method checks if the given object is actually
     * a Product. Note that we are only interested in the Product class itself,
     * not any unrelated classes or classes that might inherit the Product class.
     *
     * @param obj the object to check
     * @return true if the given object is a Product, false otherwise
     */
    public boolean isProduct(Object obj) {

        return obj.getClass().equals(Product.class);
        
    }
}
