package com.aluracursos.screenmatch.exception;

public class ErrorConvertionOfLengthException extends RuntimeException{
    private String message;

    public ErrorConvertionOfLengthException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
