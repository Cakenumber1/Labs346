package ru.U_901;

//Упражнение 6-2
public class U1901Bank {
    private int intTo;
    private int intFrom = 220;

    public synchronized void calc(int intTransaction, long lngTimeout) {
        System.out.println("1st:" + "\nintFrom: " + intFrom + "\nintTo:" + intTo + '\n' + Thread.currentThread().getName());

        intFrom -= intTransaction;

        try {
            Thread.sleep(lngTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        intTo += intTransaction;

        System.out.println("2nd:" + "\nintFrom: " + intFrom + "\nintTo:" + intTo + "\nThread" + Thread.currentThread().getName());

    }

}
