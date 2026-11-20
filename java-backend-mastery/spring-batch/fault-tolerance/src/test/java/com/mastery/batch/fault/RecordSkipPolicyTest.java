package com.mastery.batch.fault;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.step.skip.SkipLimitExceededException;

class RecordSkipPolicyTest {

    @Test
    void skipsUntilLimit() {
        var policy = new RecordSkipPolicy(2);
        assertTrue(policy.shouldSkip(new IllegalArgumentException("bad row"), 0));
        assertThrows(SkipLimitExceededException.class,
                () -> policy.shouldSkip(new IllegalArgumentException("bad row"), 2));
    }

    @Test
    void doesNotSkipOtherExceptions() {
        assertFalse(new RecordSkipPolicy(2).shouldSkip(new IllegalStateException("fatal"), 0));
    }
}
