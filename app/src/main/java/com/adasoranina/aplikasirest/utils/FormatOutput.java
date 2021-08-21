package com.adasoranina.aplikasirest.utils;

public class FormatOutput {

    public static String formatEmptyDataString(String data) {
        if (data.isEmpty()) {
            return "Kosong";
        }

        return data;
    }

}
