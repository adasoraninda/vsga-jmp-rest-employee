package com.adasoranina.aplikasirest.model.response;

import com.google.gson.annotations.SerializedName;

public class ResultResponse<T> {

    @SerializedName(value = "result")
    private final T result;

    public ResultResponse(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }
}
