#!/usr/bin/env bash
set -euo pipefail

LOG_FILE="${1:-../sample-logs/app.log}"

if [[ ! -f "$LOG_FILE" ]]; then
    echo "Log file not found: $LOG_FILE"
    exit 1
fi

echo "Analyzing log file: $LOG_FILE"
echo "------------------------------------------"
echo "Total Lines : $(wc -l < "$LOG_FILE")"
echo "INFO Count  : $(grep -c "INFO" "$LOG_FILE" || true)"
echo "WARN Count  : $(grep -c "WARN" "$LOG_FILE" || true)"
echo "ERROR Count : $(grep -c "ERROR" "$LOG_FILE" || true)"
echo ""
echo "--- Top Error Messages ---"
grep "ERROR" "$LOG_FILE" | awk -F' - ' '{print $2}' | sort | uniq -c | sort -nr
