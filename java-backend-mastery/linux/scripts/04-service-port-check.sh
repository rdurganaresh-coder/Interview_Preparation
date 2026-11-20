#!/usr/bin/env bash
set -euo pipefail

HOST="${1:-localhost}"
PORTS=(8080 8081 8082 8083 8084 8761 5432 4566)

echo "Checking service ports on $HOST..."
for PORT in "${PORTS[@]}"; do
    if nc -z -w 1 "$HOST" "$PORT" 2>/dev/null; then
        echo "[OPEN]   Port $PORT is reachable"
    else
        echo "[CLOSED] Port $PORT is not listening"
    fi
done
