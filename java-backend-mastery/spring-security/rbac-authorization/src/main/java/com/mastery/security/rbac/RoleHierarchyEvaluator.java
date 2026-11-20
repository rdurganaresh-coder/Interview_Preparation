package com.mastery.security.rbac;

import java.util.Map;
import java.util.Set;

public class RoleHierarchyEvaluator {

    private static final Map<String, Set<String>> PERMISSIONS = Map.of(
            "ROLE_ADMIN", Set.of("READ", "WRITE", "DELETE"),
            "ROLE_USER", Set.of("READ"));

    public boolean hasPermission(String role, String action) {
        return PERMISSIONS.getOrDefault(role, Set.of()).contains(action);
    }
}
