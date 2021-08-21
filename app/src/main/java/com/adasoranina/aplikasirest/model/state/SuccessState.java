package com.adasoranina.aplikasirest.model.state;

public class SuccessState<T> {
    private String message;
    private T data;

    public SuccessState(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }
}
