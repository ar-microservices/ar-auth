package com.arfan.auth.mapper;

import com.arfan.auth.dto.request.MRoleRequest;
import com.arfan.auth.dto.response.MRoleResponseDTO;
import com.arfan.auth.entity.MRoleEntity;
import com.arfan.auth.utils.DateUtil;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class MRoleMapper {

    public MRoleEntity convertToEntity(MRoleRequest mRoleRequest) throws ParseException {
        MRoleEntity mRoleEntity = new MRoleEntity();
        mRoleEntity.setRoleID(mRoleRequest.getRoleID());
        mRoleEntity.setRoleAlias(mRoleRequest.getRoleAlias());
        mRoleEntity.setRoleName(mRoleRequest.getRoleName());
        mRoleEntity.setCreatedBy(mRoleRequest.getCreatedBy());
        mRoleEntity.setCreatedDate(DateUtil.parseDateTime2(mRoleRequest.getCreatedDate()));
        mRoleEntity.setLastModifiedBy(mRoleRequest.getModifiedBy());
        mRoleEntity.setModifiedDate(DateUtil.parseDateTime2(mRoleRequest.getModifiedDate()));
        return mRoleEntity;
    }

    public MRoleResponseDTO convertToDTO(MRoleEntity mRoleEntity){
        MRoleResponseDTO mRoleResponseDTO = new MRoleResponseDTO();

        mRoleResponseDTO.setRoleID(String.valueOf(mRoleEntity.getRoleID()));
        mRoleResponseDTO.setRoleAlias(mRoleEntity.getRoleAlias());
        mRoleResponseDTO.setRoleName(mRoleEntity.getRoleName());
        mRoleResponseDTO.setCreatedBy(mRoleEntity.getCreatedBy());
        if (mRoleEntity.getCreatedDate() != null){
            mRoleResponseDTO.setCreatedDate(DateUtil.formatDateYD6(mRoleEntity.getCreatedDate()));
        }
        mRoleResponseDTO.setModifiedBy(mRoleEntity.getLastModifiedBy());
        if (mRoleEntity.getModifiedDate() != null){
            mRoleResponseDTO.setModifiedDate(DateUtil.formatDateYD6(mRoleEntity.getModifiedDate()));
        }
        return mRoleResponseDTO;
    }
}
