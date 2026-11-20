package com.mastery.security.rbac;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RoleHierarchyEvaluatorTest {

    @Test
    void adminCanDeleteUserCannot() {
        var eval = new RoleHierarchyEvaluator();
        assertTrue(eval.hasPermission("ROLE_ADMIN", "DELETE"));
        assertFalse(eval.hasPermission("ROLE_USER", "DELETE"));
        assertFalse(eval.hasPermission("ROLE_GUEST", "READ"));
    }
}
