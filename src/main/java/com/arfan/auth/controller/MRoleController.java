package com.arfan.auth.controller;

import com.arfan.auth.dto.ApiResponse;
import com.arfan.auth.dto.request.MRoleRequest;
import com.arfan.auth.dto.response.MRoleResponseDTO;
import com.arfan.auth.enums.Constants;
import com.arfan.auth.enums.ResponseEnum;
import com.arfan.auth.service.MRoleService;
import com.arfan.auth.utils.ResponseBuilderHelper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
@RestController
@RequestMapping(value = "/api/v1/role")
@Slf4j
public class MRoleController {

    private final ResponseBuilderHelper responseBuilderHelper;
    private final MRoleService mRoleService;
    private static final String API_VERSION_1 = "v1";

    public MRoleController(ResponseBuilderHelper responseBuilderHelper, MRoleService mRoleService) {
        this.responseBuilderHelper = responseBuilderHelper;
        this.mRoleService = mRoleService;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @Operation(summary = "Save Roles")
    @PostMapping
    public ResponseEntity<ApiResponse> save(@RequestBody @Validated MRoleRequest mRoleRequest) throws ParseException {
        MRoleResponseDTO mRoleResponseDTO = mRoleService.save(mRoleRequest);
        return responseBuilderHelper.buildSigleResponse(
                ResponseEnum.SUCCESS,
                API_VERSION_1,
                Integer.toString(Constants.OK),
                Constants.GLB_MESSAGE_SUCCESS,
                mRoleResponseDTO
        );
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Operation(summary = "Get all roles")
    public ResponseEntity<ApiResponse> getAll(){
        List<MRoleResponseDTO> mRoleResponseDTOS = mRoleService.getAll();
        return responseBuilderHelper.buildSigleResponse(
                ResponseEnum.SUCCESS,
                API_VERSION_1,
                Integer.toString(Constants.OK),
                Constants.GLB_MESSAGE_SUCCESS,
                mRoleResponseDTOS
        );
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("{roleID}")
    @Operation(summary = "Get role by RoleID")
    public ResponseEntity<ApiResponse> findByRoleId(@PathVariable String roleID){
        MRoleResponseDTO mRoleResponseDTOS = mRoleService.findByRoleID(roleID);
        return responseBuilderHelper.buildSigleResponse(
                ResponseEnum.SUCCESS,
                API_VERSION_1,
                Integer.toString(Constants.OK),
                Constants.GLB_MESSAGE_SUCCESS,
                mRoleResponseDTOS
        );
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("{roleID}")
    @Operation(summary = "Delete role by roleID")
    public ResponseEntity<ApiResponse> delete(@PathVariable String roleID) {
        MRoleResponseDTO mRoleResponseDTO = mRoleService.delete(roleID);
        return responseBuilderHelper.buildSigleResponse(
                ResponseEnum.SUCCESS,
                API_VERSION_1,
                Integer.toString(Constants.OK),
                Constants.GLB_MESSAGE_SUCCESS,
                mRoleResponseDTO
        );
    }



}
