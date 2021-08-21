package com.adasoranina.aplikasirest.utils;

public interface NetworkCallback<T> {
    void success(T data);
    void error(String message);
}
