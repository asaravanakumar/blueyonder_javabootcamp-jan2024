package com.blueyonder.bankingapp.exception;

public class FundTransferException extends Exception{

    public FundTransferException() {
    }

    public FundTransferException(String message) {
        super(message);
    }

    public FundTransferException(String message, Throwable cause) {
        super(message, cause);
    }
}
