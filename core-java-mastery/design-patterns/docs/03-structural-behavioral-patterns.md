# Structural & Behavioral Patterns

## Strategy Pattern (Functional Java Approach)
Encapsulates interchangeable algorithms behind a common interface or functional map:
```java
Map<String, UnaryOperator<Double>> discountStrategies = Map.of(
    "NONE", price -> price,
    "FESTIVE", price -> price * 0.85,
    "VIP", price -> price * 0.70
);
```

## Decorator & Observer
- **Decorator**: Wraps an object dynamically to add responsibilities (e.g., `BufferedInputStream` wrapping `FileInputStream`).
- **Observer**: Notifies dependent subscribers automatically when subject state changes.
