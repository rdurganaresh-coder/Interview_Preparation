package com.mastery.aws.iam;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IamPolicyValidatorTest {

    @Test
    void rejectsWildcards() {
        var validator = new IamPolicyValidator();
        assertTrue(validator.isLeastPrivilege("s3:GetObject", "arn:aws:s3:::my-bucket/*"));
        assertFalse(validator.isLeastPrivilege("*", "*"));
    }
}
