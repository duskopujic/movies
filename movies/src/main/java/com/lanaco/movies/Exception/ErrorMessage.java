package com.lanaco.movies.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private String timestamp;
    private int status;
    private String error;
    private String path;
}
