# react-workspace

npm workspaces (declared in the root `package.json`):

- `apps/web` - Vite + React 19 + TypeScript SPA (proxies `/api` to http://localhost:8080)
- `packages/ui` - shared React components (`@mastery/ui`)
- `packages/api-client` - typed fetch helpers (`@mastery/api-client`)
