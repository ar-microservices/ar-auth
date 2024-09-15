package com.arfan.auth.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "M_ROLE")
public class MRoleEntity extends BaseEntity implements Serializable {

    @Id
    @Column(name = "ROLE_ID")
    @NotNull
    @NotBlank
    @Size(max = 36)
    private String roleID;

    @Column(name = "ROLE_ALIAS")
    @jakarta.validation.constraints.NotNull
    @NotBlank
    @Size(max = 5)
    private String roleAlias;

    @Column(name = "ROLE_NAME")
    @NotNull
    @NotBlank
    @Size(max = 20)
    private String roleName;

    @Override
    public int hashCode() {
        return Objects.hash(roleID);
    }

}
