package com.mastery.batch.fault;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;

public class RecordSkipPolicy implements SkipPolicy {

    private final int maxSkips;

    public RecordSkipPolicy(int maxSkips) {
        this.maxSkips = maxSkips;
    }

    @Override
    public boolean shouldSkip(Throwable t, long skipCount) throws SkipLimitExceededException {
        if (t instanceof IllegalArgumentException) {
            if (skipCount >= maxSkips) {
                throw new SkipLimitExceededException(maxSkips, t);
            }
            return true;
        }
        return false;
    }
}
