# SecurityFilterChain & CORS
- Configure `SecurityFilterChain` bean with stateless session policy (`SessionCreationPolicy.STATELESS`).
- Enable `http.cors(Customizer.withDefaults())` so preflight `OPTIONS` requests pass.
