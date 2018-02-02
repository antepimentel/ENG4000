package com.example.antepimentel.eng4000.Exceptions;

/**
 * Created by Ante Pimentel on 2/2/2018.
 */

public class NotEnoughPointsException extends RuntimeException{

    public NotEnoughPointsException(String message){
        super(message);
    }
}
