# Front-End Mastery

| Folder | What it is |
|---|---|
| `html-css-js` | Semantic HTML5, CSS Grid/Flexbox, vanilla ES modules |
| `typescript-core` | Strict TypeScript: generics, type guards |
| `react-workspace` | `apps/web` (Vite + React 19) + `packages/ui` + `packages/api-client` |
| `angular-workspace` | Standalone Angular app: signals, RxJS, HttpClient |

## Quick start
```bash
npm install              # installs html-css-js, typescript-core and react-workspace
npm run react:dev        # http://localhost:3000  (proxy /api -> :8080)
npm run ts:typecheck

npm run angular:install  # Angular is installed separately
npm run angular:start    # http://localhost:4200  (proxy /api -> :8080)
```

Start the Java backend on port 8080 so `/api/v1/orders` resolves.
