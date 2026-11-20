package com.mastery.aws.s3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class S3ObjectKeyBuilderTest {

    @Test
    void buildsPartitionedKey() {
        var builder = new S3ObjectKeyBuilder();
        assertEquals("tenants/acme/year=2026/month=11/report.csv",
                builder.buildPartitionedKey("acme", LocalDate.of(2026, 11, 20), "report.csv"));
    }
}
