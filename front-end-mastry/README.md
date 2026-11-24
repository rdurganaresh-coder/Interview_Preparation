# Front-End Mastry

Multi-module frontend workspace using **npm workspaces**, sharing TypeScript models across Angular 18 and React 18 applications.

## Workspace Structure
- `typescript-core/shared-models` (`@front-end-mastry/shared-models`) — Shared interfaces (`TopicItem`, `OrderSummary`, `ApiResponse`) imported by Angular & React.
- `typescript-core/ts-fundamentals` — Standalone TypeScript exercises.
- `angular-workspace/` — Multi-project Angular 18 workspace:
  - `projects/angular-basics` (Port **4201**)
  - `projects/angular-dashboard` (Port **4202**) — Includes Angular Router & lazy-loaded feature routes (`/topics`, `/orders`).
- `react-workspace/` — Multi-app React 18 + Vite workspace:
  - `react-basics` (Port **3003**)
  - `react-backend-dashboard` (Port **3004**) — Includes React Router v6 & feature pages (`/topics`, `/orders`).
- `html-css-js/` — Vanilla HTML/CSS (**3001**) and ES6+ JS (**3002**).

## Quick Start
1. Run `npm install` once in the root `front-end-mastry` folder.
2. Start any module from root:
   - `npm run start:angular-basics` -> http://localhost:4201
   - `npm run start:angular-dashboard` -> http://localhost:4202
   - `npm run start:react-basics` -> http://localhost:3003
   - `npm run start:react-dashboard` -> http://localhost:3004
   - `npm run start:html-css` -> http://localhost:3001
   - `npm run start:js-es6` -> http://localhost:3002
   - `npm run start:ts` -> Runs TS fundamentals
