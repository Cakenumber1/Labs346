package ru.U_901;

//Лаб 3 Упражнение 2-1
public class U0901WorkArray<T extends Number> {

    U0901WorkArray(T[] array) {
        this.arrNums = array;
    }

    T[] arrNums;

    public double sum() {
        double doubleWork = 0;
        for (int i = 0; i < arrNums.length; i++) {
            doubleWork += arrNums[i].doubleValue();
        }
        return doubleWork;
    }
}
