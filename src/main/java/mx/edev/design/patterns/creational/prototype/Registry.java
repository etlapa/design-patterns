package mx.edev.design.patterns.creational.prototype;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Registry {

    private static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private Map<String, Item> items = new HashMap<String, Item>();

    public Registry() {
        loadItems();
    }

    public Item createItem(String type) {
        Item item = null;

        try {
            item = (Item) items.get(type).clone();
        } catch (CloneNotSupportedException e) {
            LOGGER.error(e.getMessage());
        }

        return item;
    }

    private void loadItems() {
        Movie movie = new Movie();
        movie.setTitle("Basic Movie");
        movie.setPrice(24.99);
        movie.setRuntime("2 hours");
        items.put("Movie", movie);

        Book book = new Book();
        book.setNumberOfPages(335);
        book.setPrice(19.99);
        book.setTitle("Basic Book");
        items.put("Book", book);
    }
}