package com.arfan.auth.service.impl;

import ch.qos.logback.core.spi.ErrorCodes;
import com.arfan.auth.dto.request.MRoleRequest;
import com.arfan.auth.dto.response.MRoleResponseDTO;
import com.arfan.auth.entity.MRoleEntity;
import com.arfan.auth.enums.ErrorCode;
import com.arfan.auth.mapper.MRoleMapper;
import com.arfan.auth.repository.MRoleRepository;
import com.arfan.auth.service.MRoleService;
import org.hibernate.exception.DataException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MRoleServiceImpl implements MRoleService {

    MRoleRepository mRoleRepository;
    MRoleMapper mRoleMapper;

    public MRoleServiceImpl(MRoleRepository mRoleRepository, MRoleMapper mRoleMapper) {
        this.mRoleRepository = mRoleRepository;
        this.mRoleMapper = mRoleMapper;
    }

    @Override
    public MRoleResponseDTO save(MRoleRequest mRoleRequest) throws ParseException {
        if(mRoleRequest.getRoleID() != null) {
            return update(mRoleRequest, mRoleRequest.getRoleID());
        }else{
            return submitSave(mRoleRequest);
        }
    }

    @Override
    public List<MRoleResponseDTO> getAll() {
        List<MRoleResponseDTO> mRoleResponseDTOS = new ArrayList<>();
        List<MRoleEntity> mRoleEntities = mRoleRepository.findAll();

        for(MRoleEntity mRoleEntity : mRoleEntities) {
            MRoleResponseDTO mRoleResponseDTO = mRoleMapper.convertToDTO(mRoleEntity);
            mRoleResponseDTOS.add(mRoleResponseDTO);
        }
        return  mRoleResponseDTOS;
    }

    @Override
    public MRoleResponseDTO findByRoleID(String roleID) {
        try {
            MRoleEntity mRoleEntity = mRoleRepository.findByRoleID(roleID);
            if(mRoleEntity == null) {
                throw new Exception("Could not find role");
            }
            return mRoleMapper.convertToDTO(mRoleEntity);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MRoleResponseDTO delete(String roleID) {
        MRoleEntity mRoleEntity = mRoleRepository.findByRoleID(roleID);
        if(mRoleEntity == null) {
            return  null;
        }
        mRoleRepository.delete(mRoleEntity);
        return mRoleMapper.convertToDTO(mRoleEntity);
    }


    private MRoleResponseDTO update(MRoleRequest mRoleRequest, String roleID) throws ParseException {
        Boolean exist = isExist(roleID);
        if (exist){
            MRoleEntity mRoleEntity = mRoleRepository.findByRoleID(roleID);
            MRoleEntity mRoleEntityUpdate = mRoleMapper.convertToEntity(mRoleRequest);
            mRoleEntityUpdate.setRoleID(mRoleEntity.getRoleID());
            MRoleEntity mRoleEntityResponse = mRoleRepository.save(mRoleEntityUpdate);
            return mRoleMapper.convertToDTO(mRoleEntityResponse);
        } else {
            return submitSave(mRoleRequest);
        }
    }

    private MRoleResponseDTO submitSave(MRoleRequest mRoleRequest) throws ParseException {
        MRoleEntity mRoleEntity = mRoleMapper.convertToEntity(mRoleRequest);
        MRoleEntity mRoleEntityResponse = mRoleRepository.save(mRoleEntity);
        return mRoleMapper.convertToDTO(mRoleEntityResponse);
    }

    private Boolean isExist(String roleID){
        MRoleEntity mRoleEntity = mRoleRepository.findByRoleID(roleID);
        return mRoleEntity != null;
    }
}
