#!/usr/bin/env bash
set -euo pipefail
grep -E 'ERROR|FATAL' "${1:?usage: tail-errors.sh <logfile>}"
