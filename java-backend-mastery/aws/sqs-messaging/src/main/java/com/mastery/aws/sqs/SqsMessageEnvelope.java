package com.mastery.aws.sqs;

import java.util.UUID;

public record SqsMessageEnvelope(String messageId, String eventType, String payload) {

    public static SqsMessageEnvelope of(String eventType, String payload) {
        return new SqsMessageEnvelope(UUID.randomUUID().toString(), eventType, payload);
    }
}
