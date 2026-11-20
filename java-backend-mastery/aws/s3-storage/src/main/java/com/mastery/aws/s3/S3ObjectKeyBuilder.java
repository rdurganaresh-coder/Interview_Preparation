package com.mastery.aws.s3;

import java.time.LocalDate;

public class S3ObjectKeyBuilder {

    public String buildPartitionedKey(String tenantId, LocalDate date, String filename) {
        return String.format("tenants/%s/year=%d/month=%02d/%s",
                tenantId, date.getYear(), date.getMonthValue(), filename);
    }
}
