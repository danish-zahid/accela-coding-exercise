package com.accela.coding.exercise.dto;

import com.accela.coding.exercise.util.DateUtils;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Response<T> {
    private LocalDateTime timeStamp;
    private String message;
    private T body;

    public Response(String message) {
        this.timeStamp = DateUtils.getNow();
        this.message = message;
    }

    public Response(String message, T body) {
        this.timeStamp = DateUtils.getNow();
        this.message = message;
        this.body = body;
    }
}
