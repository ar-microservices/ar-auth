package com.arfan.auth.dto;

import com.arfan.auth.enums.ResponseEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
public class ErrorResponse extends BaseResponse {
    private String requestId;
    public ErrorResponse(ResponseEnum success, String apiVersion, String code, String message) {
        super(success,apiVersion, code, message);
        this.requestId = generateRequestID();
    }

    public ErrorResponse(ResponseEnum success, String apiVersion, String code, String message, String requestId) {
        super(success, apiVersion, code, message);
        this.requestId = requestId != null ? requestId : generateRequestID();
    }

    private String generateRequestID() {
        return UUID.randomUUID().toString();
    }
}
