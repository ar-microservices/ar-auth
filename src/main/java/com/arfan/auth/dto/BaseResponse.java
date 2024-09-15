package com.arfan.auth.dto;

import com.arfan.auth.enums.ResponseEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BaseResponse {
    private ResponseEnum success;
    private String apiVersion;
    private String code;
    private String message;
}

