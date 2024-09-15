package com.arfan.auth.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MRoleRequest {

    @NotBlank(message = "Role ID Can Not be Empty")
    @NotNull(message = "Role ID Can Not be Null")
    @Size(max = 36, message = "Role ID Max 36 characters")
    private String roleID;

    @NotBlank(message = "Role Alias Can Not be Empty")
    @NotNull(message = "Role Alias Can Not be Null")
    @Size(max = 5, message = "Role Alias Max 5 characters")
    private String roleAlias;

    @NotBlank(message = "Role Name Can Not be Empty")
    @NotNull(message = "Role Name Can Not be Null")
    @Size(max = 20, message = "Role Name Max 20 characters")
    private String roleName;

    private String createdBy;
    private String createdDate;
    private String modifiedBy;
    private String modifiedDate;
}
