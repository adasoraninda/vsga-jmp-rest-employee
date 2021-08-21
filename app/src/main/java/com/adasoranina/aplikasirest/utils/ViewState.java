package com.adasoranina.aplikasirest.utils;

public class ViewState<T> {
    private final boolean isLoading;
    private final SuccessState<T> successState;
    private final String error;

    private ViewState(boolean isLoading, SuccessState<T> successState, String error) {
        this.isLoading = isLoading;
        this.successState = successState;
        this.error = error;
    }

    public static <T> ViewState<T> loading(boolean isLoading) {
        return new ViewState<>(isLoading, null, null);
    }

    public static <T> ViewState<T> success(SuccessState<T> successState) {
        return new ViewState<>(false, successState, null);
    }

    public static <T> ViewState<T> error(String message) {
        return new ViewState<>(false, null, message);
    }

    public boolean isLoading() {
        return isLoading;
    }

    public String getError() {
        return error;
    }

    public SuccessState<T> getSuccessState() {
        return successState;
    }

}
