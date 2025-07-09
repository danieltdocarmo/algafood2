package com.algafood.algafood.infra.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.algafood.algafood.domain.repositories.PermissionRepository;
import org.springframework.stereotype.Repository;

import com.algafood.algafood.domain.entities.Permission;

@Repository
public class PermissionRepositoryImpl implements PermissionRepository {

    @PersistenceContext
    private EntityManager manager;

    public List<Permission> list() {
        return manager.createQuery("from Permission", Permission.class).getResultList();
    }
}