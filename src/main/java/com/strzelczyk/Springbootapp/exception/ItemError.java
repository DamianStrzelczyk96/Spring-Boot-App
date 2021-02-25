package com.strzelczyk.Springbootapp.exception;

public enum ItemError {

    ORDER_LIST_IS_EMPTY("Order does not contains any items"),
    ITEM_DOES_NOT_EXIST("Item with that ID does not exist"),
    ITEM_LIST_IS_EMPTY("Item list is empty"),
    ORDER_WITH_THAT_ID_DOES_NOT_EXIST("Order with that ID does not exist"),
    YOU_DO_NOT_HAVE_ANY_ORDERS("You do not have any orders");



    private String message;

    ItemError(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
