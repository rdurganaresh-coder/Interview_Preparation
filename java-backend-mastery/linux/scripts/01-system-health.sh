#!/usr/bin/env bash
set -euo pipefail

echo "=========================================="
echo "        LINUX SYSTEM HEALTH REPORT        "
echo "=========================================="
echo "Hostname   : $(hostname)"
echo "Kernel     : $(uname -r)"
echo "Uptime     : $(uptime -p || uptime)"
echo ""
echo "--- Memory Usage ---"
free -h
echo ""
echo "--- Disk Usage ---"
df -h /
echo ""
echo "--- Top 5 CPU Processes ---"
ps -eo pid,ppid,cmd,%mem,%cpu --sort=-%cpu | head -n 6
