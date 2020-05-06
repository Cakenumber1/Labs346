package ru.billing.stocklist;

import java.util.Date;
import java.util.Objects;

//Лаб 3 Упражнение 1-1
public class FoodItem extends GenericItem {
    private Date dateOfIncome;
    private short expires;

    public FoodItem(String name, float price, FoodItem analog, Date date, short expires) {
        this.setName(name);
        this.setPrice(price);
        this.setAnalog(analog);
        this.dateOfIncome = date;
        this.expires = expires;
    }

    public FoodItem(String name, float price, short expires) {
        this(name, price, null, null, expires);
    }

    public FoodItem(String name) {
        this(name, 0.0f, null, null, (short) 0);
    }

    public void setDateOfIncome(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    public Date getDateOfIncome() {
        return dateOfIncome;
    }

    public void setExpires(short expires) {
        this.expires = expires;
    }

    public short getExpires() {
        return expires;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        FoodItem foodItem = (FoodItem) o;
        return expires == foodItem.expires &&
                Objects.equals(dateOfIncome, foodItem.dateOfIncome);
    }

    @Override
    public int hashCode() {
        var ret = Objects.hash(super.hashCode(), dateOfIncome, expires);
        return ret;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + "\tdate of income: " + dateOfIncome + "\texpires: " + expires;
    }

    public void printAll() {
        System.out.printf("ID: %d , " +
                        "Name: %-20s , " +
                        "Analog: %-20s , " +
                        "Price: %5.2f , " +
                        "Category: %-8s , " +
                        "Expires: %d , " +
                        "Date: %7$td %7$tB %7$tY\n",
                this.getID(), this.getName(), this.getAnalog(), this.getPrice(), this.getCategory(), expires, dateOfIncome);
    }
}
