package com.arfan.auth.enums;

public enum ErrorCode {
    NotFound(404),
    BadRequest(400),
    UnAuthorize(401),
    Forbidden(403),
    BruteForceDetected(413),
    InternalServerErr(500),
    UserAd1AccessNotFound(4001);

    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int toInt() {
        return code;
    }

    @Override
    public String toString() {
        return String.valueOf(code);
    }
}
