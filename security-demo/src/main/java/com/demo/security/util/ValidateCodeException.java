package com.demo.security.util;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author chen bo
 * @Date 2023/12
 * @Des
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = 1715361291615299823L;

    public ValidateCodeException(String explanation) {
        super(explanation);
    }
}