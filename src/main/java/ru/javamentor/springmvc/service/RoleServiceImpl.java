package ru.javamentor.springmvc.service;

import org.springframework.stereotype.Service;
import ru.javamentor.springmvc.model.Role;
import ru.javamentor.springmvc.repositories.RoleRepository;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    @Override
    public Set<Role> findByIdRoles(List<Long> roles) {
        return new HashSet<>(roleRepository.findAllById(roles));
    }
}