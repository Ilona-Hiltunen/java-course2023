package part09;

import java.util.List;
import java.util.stream.Stream;

import pizza.Pizza;

/**
 * Pineapple is a controversial pizza topping. Some people love it, some people
 * hate it. Some people even think that it's a crime against humanity to put
 * pineapple on a pizza.
 *
 * In this exercise you will implement a few methods that can be used to select
 * pizzas based on their personal preferences.
 */
public class PizzaStreams {

    /**
     * Returns a stream of pizzas that have "pineapple" as a topping.
     *
     * @param pizzas a stream of pizzas
     * @return a stream of pizzas that have "pineapple" as a topping
     */
    public Stream<Pizza> getPizzasWithPineapple(Stream<Pizza> pizzas) {
        
        return pizzas.filter(p -> p.toppings().contains("pineapple"));
    }

    /**
     * Returns a stream of pizzas that do not have "pineapple" as a topping.
     *
     * @param pizzas a stream of pizzas
     * @return a stream of pizzas that do not have "pineapple" as a topping
     */
    public Stream<Pizza> getPizzasWithoutPineapple(Stream<Pizza> pizzas) {
       
        return pizzas.filter(p -> ! p.toppings().contains("pineapple"));
    }

    /**
     * Returns a stream of pizzas that have the given topping. Toppings are
     * always in lower case.
     *
     * @param pizzas  a stream of pizzas
     * @param topping the topping to look for
     * @return a stream of pizzas that have the given topping
     */
    public Stream<Pizza> getPizzasWithTopping(Stream<Pizza> pizzas, String topping) {
       
        return pizzas.filter(p -> p.toppings().contains(topping));
    }

    /**
     * Returns a stream of pizzas that have any of the toppings given as the
     * second parameter. Toppings are always in lower case.
     *
     * @param pizzas   a stream of pizzas
     * @param toppings the toppings to look for
     * @return a stream of pizzas that have any of the given toppings
     */
    public Stream<Pizza> getPizzasWithAnyOfToppings (Stream<Pizza> pizzas, List<String> toppings) {
        
        return pizzas.filter(p -> p.checkPizza(p, toppings));
    }

    /**
     * Returns a stream of pizzas that is sorted by price in ascending order
     * (cheapest first). If two pizzas have the same price, they can be in
     * any order.
     *
     * @param pizzas a stream of pizzas
     * @return a stream of pizzas that is sorted by price in ascending order
     */
    public Stream<Pizza> sortPizzasByPrice(Stream<Pizza> pizzas) {
        
        return pizzas.sorted((a, b) -> Double.compare(a.price(), b.price()));
    }

    /**
     * Returns a stream of pizzas that is sorted by name in alphabetical order.
     *
     * @param pizzas a stream of pizzas
     * @return a stream of pizzas that is sorted by name in alphabetical order
     */
    public Stream<Pizza> sortPizzasByName(Stream<Pizza> pizzas) {
       
        return pizzas.sorted((a, b) -> a.name().compareToIgnoreCase(b.name()));
    }
}
