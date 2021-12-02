package com.lanaco.movies.Exception;

public class TokenExpiredException extends Exception {
    private static final long serialVersionUID = 238659937053706543L;

    public TokenExpiredException(String message) {
        super(message);
    }
}
