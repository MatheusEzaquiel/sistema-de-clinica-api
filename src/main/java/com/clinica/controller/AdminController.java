package com.clinica.controller;

import com.clinica.domain.admin.Admin;
import com.clinica.domain.admin.dto.CreateAdminDTO;
import com.clinica.domain.admin.dto.DetailAdminDTO;
import com.clinica.domain.admin.dto.UpdateAdminDTO;
import com.clinica.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping
    public ResponseEntity<List<DetailAdminDTO>> list() {
        List<DetailAdminDTO> admins = adminService.list();
        return ResponseEntity.status(HttpStatus.OK).body(admins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailAdminDTO> get(@PathVariable UUID id) {
        DetailAdminDTO admins = adminService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(admins);
    }

    @PostMapping
    public ResponseEntity<DetailAdminDTO> save(@RequestBody CreateAdminDTO data) {
        DetailAdminDTO admins = adminService.save(data);
        return ResponseEntity.status(HttpStatus.OK).body(admins);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailAdminDTO> update(@PathVariable UUID id, @RequestBody UpdateAdminDTO data) {
        DetailAdminDTO adminDTO = adminService.update(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(adminDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetailAdminDTO> delete(@PathVariable UUID id) {
        DetailAdminDTO adminDTO = adminService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(adminDTO);
    }

}
