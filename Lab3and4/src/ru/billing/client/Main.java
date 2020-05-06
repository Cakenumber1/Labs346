package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.Category;
import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.ItemCatalog;
import java.io.IOException;
import java.util.Date;

//Упражнение 4
public class Main {

    public static void main(String[] args) throws CatalogLoadException, IOException {
        //Создание товаров
        GenericItem a = new GenericItem("A", 1f, Category.FOOD);
        GenericItem b = new GenericItem("B", 2f, Category.PRINT);
        GenericItem c = new GenericItem("C", 3f, Category.DRESS);
        GenericItem d = new GenericItem("D", 4f, Category.GENERAL);
        GenericItem f = new GenericItem("F", 5f, Category.FOOD);



        ItemCatalog itCat = new ItemCatalog();
        try {
            itCat.addItem(a);
            itCat.addItem(b);
            itCat.addItem(c);
            itCat.addItem(d);
            itCat.addItem(f);
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
        }

        long begin = new Date().getTime();

        for (int i = 0; i < 100000; i++) {
            itCat.findItemByID(10);
        }
        long end = new Date().getTime();
        System.out.println("In HashMap: " + (end - begin));
        begin = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            itCat.findItemByIDAL(10);
        }
        end = new Date().getTime();
        System.out.println("In ArrayList: " + (end - begin));

        CatalogLoader loader = new CatalogStubLoader();
        try {
            loader.load(itCat);
        } catch (CatalogLoadException e) {
            e.printStackTrace();
        }

        CatalogFileLoader fileLoader = new CatalogFileLoader("C:\\Users\\Миша\\Desktop\\Lab3and4\\text.txt");
        try {
            fileLoader.load(itCat);
        } catch (IOException e) {
            e.printStackTrace();
        }

        itCat.printItems();
    }
}
