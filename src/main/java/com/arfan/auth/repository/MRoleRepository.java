package com.arfan.auth.repository;

import com.arfan.auth.entity.MRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
//@EnableJpaRepositories
public interface MRoleRepository extends JpaRepository<MRoleEntity, String> {
    MRoleEntity findByRoleID(String roleID);
}
