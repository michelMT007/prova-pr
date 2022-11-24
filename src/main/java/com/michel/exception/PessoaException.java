package com.michel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaException extends NullPointerException {
    private static final long serialVersionUID = 1L;
}


