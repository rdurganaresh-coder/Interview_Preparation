package com.mastery.batch.tasklet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.batch.repeat.RepeatStatus;

class ArchiveCleanupTaskletTest {

    @Test
    void finishesImmediately() throws Exception {
        assertEquals(RepeatStatus.FINISHED, new ArchiveCleanupTasklet().execute(null, null));
    }
}
