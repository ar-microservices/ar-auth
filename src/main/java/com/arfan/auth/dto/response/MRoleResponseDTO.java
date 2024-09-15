package com.arfan.auth.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MRoleResponseDTO {
    private String roleID;
    private String roleAlias;
    private String roleName;
    private String createdBy;
    private String createdDate;
    private String modifiedBy;
    private String modifiedDate;
}
