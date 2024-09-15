package com.arfan.auth.utils;

import com.arfan.auth.dto.ApiResponse;
import com.arfan.auth.dto.ErrorResponse;
import com.arfan.auth.enums.ResponseEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseBuilderHelper {
    public ResponseEntity<ApiResponse> buildSigleResponse(ResponseEnum success, String apiVersion, String code, String message, Object data) {
        return new ResponseEntity<>(
                new ApiResponse(success, apiVersion, code, message, data),
                HttpStatus.OK
        );
    }

    public ResponseEntity<ErrorResponse> buildExceptionResponse(String code, String apiVersion, String message) {
        return new ResponseEntity<>(
                new ErrorResponse(
                        ResponseEnum.FAIL,
                        apiVersion,
                        code,
                        message
                ),
                HttpStatus.OK
        );
    }

}
