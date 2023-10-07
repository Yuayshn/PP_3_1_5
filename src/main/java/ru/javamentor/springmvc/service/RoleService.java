package ru.javamentor.springmvc.service;

import ru.javamentor.springmvc.model.Role;
import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> getAllRoles();
    Set<Role> findByIdRoles(List<Long>roles);
}
