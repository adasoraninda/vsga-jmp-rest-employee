package com.adasoranina.aplikasirest.network;

public final class EmployeeEndPoint {
    public static final String VARIABLE_ID = "id";
    public static final String BASE_URL = "http://192.168.18.127/pegawai/";
    public static final String URL_ADD = BASE_URL + "tambahpgw.php";
    public static final String URL_GET_ALL = BASE_URL + "tampilsemuapgw.php";
    public static final String URL_GET_EMP = BASE_URL + "tampilpgw.php";  // Query id
    public static final String URL_UPDATE_EMP = BASE_URL + "updatepgw.php";
    public static final String URL_DELETE_EMP = BASE_URL + "hapuspgw.php";  // Query id
}
