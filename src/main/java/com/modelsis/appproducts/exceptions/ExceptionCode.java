package com.modelsis.appproducts.exceptions;

public enum ExceptionCode {
    PRODUCT_NOT_FOUND(1001, "Pas de produit trouvé"),
    PRODUCT_NOT_SAVED(1001, "Echec sauvegarde produit"),
    PRODUCT_TYPE_NOT_FOUND(2001, "Pas de type de produit trouvé"),
    PRODUCT_TYPE_NOT_SAVED(2002, "Echec sauvegarde type de produit.");
    private int value;
    private String message;

    ExceptionCode(int value, String message) {
        this.value   = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

}
