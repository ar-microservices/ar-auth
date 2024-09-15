package com.arfan.auth.service;

import com.arfan.auth.dto.request.MRoleRequest;
import com.arfan.auth.dto.response.MRoleResponseDTO;

import java.text.ParseException;
import java.util.List;

public interface MRoleService {
    MRoleResponseDTO save(MRoleRequest mRoleRequest) throws ParseException;
    List<MRoleResponseDTO> getAll();
}
