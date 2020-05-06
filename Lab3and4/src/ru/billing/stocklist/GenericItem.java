package ru.billing.stocklist;

import java.util.Objects;

//Лаб 3 Упражнение 1-1
public class GenericItem implements Cloneable {
    private static int currentID;
    private int id;
    private String name;
    private float price;
    private GenericItem analog;
    private Category category = Category.GENERAL;


    public GenericItem(String name, float price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.id = GenericItem.currentID++;
    }

    public GenericItem(String name, float price, GenericItem analog) {
        this(name, price, Category.GENERAL);
        this.analog = analog;
    }

    public GenericItem() {
        this(null, 0.0f, Category.GENERAL);
    }

    public int getID() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public float getPrice() {
        return price;
    }

    public void setAnalog(GenericItem analog) {
        this.analog = analog;
    }

    public GenericItem getAnalog() {
        return analog;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GenericItem that = (GenericItem) o;
        return id == that.id &&
                Float.compare(that.price, price) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(analog, that.analog) &&
                category == that.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, analog, category);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "ID: " + id + "\tname: " + name + "\tprice: " + price + "\tanalog: " + analog + "\tcategory: " + category;
    }

    public void printAll() {
        System.out.printf("ID: %d , " +
                        "Name: %-20s , " +
                        "Analog: %-20s , " +
                        "Price: %5.2f , " +
                        "Category: %-8s\n",
                id, name, analog, price, category);
    }
}
