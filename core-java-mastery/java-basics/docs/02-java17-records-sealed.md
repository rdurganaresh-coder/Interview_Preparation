# Java 17 Records & Sealed Types

## Records (`record`)
Records eliminate boilerplate (`equals`, `hashCode`, `toString`, constructors, getters) for transparent data carriers:

```java
public record UserProfile(String id, String username, String email) {
    public UserProfile {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be blank");
        }
    }
}
```

## Sealed Classes & Interfaces (`sealed` / `permits`)
Sealed types restrict which classes can extend or implement a parent type, enabling exhaustive `switch` checks:

```java
public sealed interface PaymentResult permits PaymentSuccess, PaymentFailure {}
public record PaymentSuccess(String transactionId) implements PaymentResult {}
public record PaymentFailure(String reason) implements PaymentResult {}
```
