package com.mastery.springboot.config;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "mastery.app")
public record AppProperties(@NotBlank String environmentName, @Min(1) int maxRetries) {}
