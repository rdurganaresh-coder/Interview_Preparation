# Asynchronous Pipelines with `CompletableFuture`

`CompletableFuture` enables non-blocking task composition:

```java
CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> fetchUser(id));
CompletableFuture<String> orderFuture = CompletableFuture.supplyAsync(() -> fetchOrders(id));

String combined = userFuture
    .thenCombine(orderFuture, (user, orders) -> user + " -> " + orders)
    .exceptionally(ex -> "Fallback response: " + ex.getMessage())
    .join();
```

## Key Methods
- `thenApply`: Synchronous transform (like `Stream.map`).
- `thenCompose`: Chains another dependent `CompletableFuture` (like `Stream.flatMap`).
- `allOf`: Waits for multiple independent futures to complete in parallel.
