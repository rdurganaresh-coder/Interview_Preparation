# API Gateway Routing & Filters
- Routes `/orders/**` to `lb://order-service` and `/payments/**` to `lb://payment-service`.
- Handles global CORS, rate limiting, and JWT header forwarding.
