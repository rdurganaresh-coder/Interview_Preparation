# Creational Design Patterns

## Thread-Safe Singleton (Bill Pugh Holder Pattern)
Relies on JVM class-loading guarantees without synchronization overhead:
```java
public final class AppConfig {
    private AppConfig() {}
    private static class Holder {
        private static final AppConfig INSTANCE = new AppConfig();
    }
    public static AppConfig getInstance() {
        return Holder.INSTANCE;
    }
}
```

## Builder Pattern
Separates step-by-step construction of complex immutable objects from their representation, avoiding telescoping constructors.
