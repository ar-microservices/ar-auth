package com.arfan.auth.enums;

public enum ResponseEnum {
    SUCCESS(true),
    FAIL(false);

    private final boolean flasResponse;

    ResponseEnum(boolean flasResponse) {
        this.flasResponse = flasResponse;
    }
}
