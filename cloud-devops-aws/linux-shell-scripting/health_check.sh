#!/usr/bin/env bash
set -euo pipefail
echo "Checking disk and memory..."
df -h / && free -m
