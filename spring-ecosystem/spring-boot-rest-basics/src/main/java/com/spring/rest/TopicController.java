package com.spring.rest;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
    @GetMapping
    public List<Map<String, Object>> getTopics() {
        return List.of(
            Map.of("id", 1, "title", "Spring Boot REST", "status", "READY"),
            Map.of("id", 2, "title", "Spring Data JPA", "status", "READY"),
            Map.of("id", 3, "title", "Spring Security JWT", "status", "READY")
        );
    }
}
