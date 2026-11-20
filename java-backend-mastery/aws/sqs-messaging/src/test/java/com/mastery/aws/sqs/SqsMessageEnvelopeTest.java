package com.mastery.aws.sqs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class SqsMessageEnvelopeTest {

    @Test
    void createsEnvelopeWithId() {
        var env = SqsMessageEnvelope.of("ORDER_CREATED", "{}");
        assertNotNull(env.messageId());
        assertEquals("ORDER_CREATED", env.eventType());
    }
}
