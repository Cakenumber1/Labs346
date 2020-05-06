package ru.billing.exceptions;

//Упражнение 6-1
public class ItemAlreadyExistsException extends Exception {
    private String nameError;

    public ItemAlreadyExistsException(ItemAlreadyExistsException e) {
        this(e.nameError);
    }

    public ItemAlreadyExistsException(String nameError) {
        this.nameError = nameError;
    }

    public String getNameError() {
        return nameError;
    }
}
