package com.algafood.algafood.domain.repositories;

import com.algafood.algafood.domain.entities.Permission;

import java.util.List;

public interface PermissionRepository {

    public List<Permission> list();
}