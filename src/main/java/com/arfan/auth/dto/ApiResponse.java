package com.arfan.auth.dto;


import com.arfan.auth.enums.ResponseEnum;
import lombok.Getter;

@Getter
public class ApiResponse extends BaseResponse {
    private Object data;

    public ApiResponse(ResponseEnum success, String apiVersion, String code, String message, Object data) {
        super(success, apiVersion, code, message);
        this.data = data;
    }

    public ApiResponse(){
        super(null,null,null,null);
    }
}
