package com.clinica.repository;

import com.clinica.domain.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IAdminRepository extends JpaRepository<Admin, UUID> {
}
