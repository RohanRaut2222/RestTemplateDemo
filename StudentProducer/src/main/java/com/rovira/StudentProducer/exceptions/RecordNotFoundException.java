package com.rovira.StudentProducer.exceptions;

public class RecordNotFoundException extends RuntimeException {
    
    public RecordNotFoundException(String msg)
    {
        super(msg);
    }
}
