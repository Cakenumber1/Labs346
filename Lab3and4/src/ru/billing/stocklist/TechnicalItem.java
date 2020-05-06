package ru.billing.stocklist;

import java.util.Objects;

//тоже из второй лабы
public class TechnicalItem extends GenericItem {
    private short warrantyTime;

    public void setWarrantyTime(short warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    public short getWarrantyTime() {
        return warrantyTime;
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
        TechnicalItem that = (TechnicalItem) o;
        return warrantyTime == that.warrantyTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), warrantyTime);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + "\twarranty time: " + warrantyTime;
    }

    public void printAll() {
        System.out.printf("ID: %d , " +
                        "Name: %-20s , " +
                        "Analog: %-20s , " +
                        "Price: %5.2f , " +
                        "Category: %-8s , " +
                        "WarrantyTime: %d\n",
                this.getID(), this.getName(), this.getAnalog(), this.getPrice(), this.getCategory(), warrantyTime);
    }
}
