package com.accela.coding.exercise.dto;

import lombok.Data;

@Data
public class Response<T> {
    private String message;
    private T body;

    public Response(String message) {
        this.message = message;
    }

    public Response(String message, T body) {
        this.message = message;
        this.body = body;
    }
}
