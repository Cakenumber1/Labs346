package ru.billing.exceptions;

//Упражнение 6-1
public class CatalogLoadException extends Exception {
    private String nameError;

    public CatalogLoadException(ItemAlreadyExistsException e) {
        this.nameError = e.getNameError();
    }

    public CatalogLoadException(String nameError) {
        this.nameError = nameError;
    }

    public String getNameError() {
        return nameError;
    }
}
