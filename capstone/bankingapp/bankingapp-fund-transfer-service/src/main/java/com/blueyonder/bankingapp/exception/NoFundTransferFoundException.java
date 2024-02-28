package com.blueyonder.bankingapp.exception;

public class NoFundTransferFoundException extends FundTransferException{
    public NoFundTransferFoundException() {
    }

    public NoFundTransferFoundException(String message) {
        super(message);
    }

    public NoFundTransferFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
