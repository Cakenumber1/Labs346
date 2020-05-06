package ru.billing.stocklist;

import ru.billing.exceptions.ItemAlreadyExistsException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Упражнение 4-1
public class ItemCatalog {
    private Map<Integer, GenericItem> catalog = new HashMap<Integer, GenericItem>();
    private List<GenericItem> allCatalog = new ArrayList<GenericItem>();

    public void addItem(GenericItem item) throws ItemAlreadyExistsException {
        try {
            for (GenericItem item1 : allCatalog) {
                if (item1.equals(item)) {
                    throw new ItemAlreadyExistsException("Item already exists in ItemCatalog");
                }
            }
        } catch (ItemAlreadyExistsException e) {
            throw new ItemAlreadyExistsException(e);
        }
        catalog.put(item.getID(), item); // Добавляем товар в HashMap
        allCatalog.add(item); // Добавляем тот же товар в ArrayList
    }

    public void printItems() {
        for (GenericItem i : allCatalog) {
            System.out.println(i);
        }
    }

    public GenericItem findItemByID(int id) {
        return catalog.getOrDefault(id, null);
    }

    public GenericItem findItemByIDAL(int id) {
        for (GenericItem i : allCatalog) {
            if (i.getID() == id) {
                return i;
            }
        }
        return null;
    }
}
