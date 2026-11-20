# angular-workspace

Standalone Angular CLI workspace (kept outside the root npm workspaces so the
Angular toolchain installs independently).

```bash
cd angular-workspace
npm install
npm start      # http://localhost:4200, /api proxied to http://localhost:8080
npm run build
```

Feature folders under `src/app/features`: `signals`, `orders` (RxJS + HttpClient).
