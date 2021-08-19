package com.adasoranina.aplikasirest.model.response;

import com.google.gson.annotations.SerializedName;

public class ListEmployeeResponse {
    @SerializedName(value = "id")
    private final Integer id;

    @SerializedName(value = "name")
    private final String name;

    public ListEmployeeResponse(Integer id, String name, String position, Integer salary) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
