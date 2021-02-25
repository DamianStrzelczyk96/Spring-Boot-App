package com.strzelczyk.Springbootapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ItemExceptionHandler {

    @ExceptionHandler(value = ItemExceptions.class)
    public ResponseEntity<ErrorInfo> handleException(ItemExceptions e){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        if(ItemError.ITEM_LIST_IS_EMPTY.equals(e.getItemError())){
            httpStatus=HttpStatus.OK;
        }else if (ItemError.ITEM_DOES_NOT_EXIST.equals(e.getItemError())){
            httpStatus=HttpStatus.OK;
        }else if (ItemError.ORDER_LIST_IS_EMPTY.equals(e.getItemError())){
            httpStatus=HttpStatus.OK;
        }else if (ItemError.ORDER_WITH_THAT_ID_DOES_NOT_EXIST.equals(e.getItemError())){
            httpStatus=HttpStatus.OK;
        }else if (ItemError.YOU_DO_NOT_HAVE_ANY_ORDERS.equals(e.getItemError())){
            httpStatus=HttpStatus.OK;
        }

        return ResponseEntity.status(httpStatus).body(new ErrorInfo(e.getItemError().getMessage()));

    }
}
