package com.strzelczyk.Springbootapp.exception;

public class ItemExceptions extends  RuntimeException{

    private ItemError itemError;

    public ItemExceptions(ItemError itemError){this.itemError = itemError;}

    public ItemError getItemError(){return itemError;}
}
