# Linux & Shell Scripting Mastery Notes

## 1. Essential File, Text & Search Commands
- **Navigation & Permissions:** `ls -la`, `chmod 755 script.sh` (`rwx r-x r-x`), `chown user:group file`
- **Finding Files:** `find /var/log -name "*.log" -mtime -7` (modified in last 7 days)
- **Searching Text:** `grep -rnw "ERROR" /var/log/` (recursive, line numbers, whole word)
- **Stream Processing:**
  - `awk '{print $1, $4}' access.log` — Extract specific columns
  - `sed -i 's/old_host/new_host/g' config.yml` — In-place find and replace
  - `sort file.txt | uniq -c | sort -nr` — Frequency count sorted descending

## 2. Process, Memory & Disk Diagnostics
- **Processes:** `ps aux | grep java`, `top` / `htop`, `kill -15 <PID>` (graceful `SIGTERM`), `kill -9 <PID>` (`SIGKILL`)
- **Memory & Disk:** `free -h` (RAM/swap), `df -h` (filesystem disk usage), `du -sh *` (directory sizes)
- **System Logs:** `journalctl -u nginx -f` (follow systemd service logs), `tail -n 100 -f app.log`

## 3. Networking & SSH
- **Open Ports:** `ss -tulnp` or `lsof -i :8080` (find which process owns port `8080`)
- **Connectivity:** `curl -I http://localhost:8081/api/health`, `dig domain.com`, `nc -zv localhost 5432`
- **Remote Access:** `ssh -i ~/.ssh/id_ed25519 user@host`, `scp app.jar user@host:/opt/apps/`

## 4. Bash Scripting Best Practices
- Always start scripts with `#!/usr/bin/env bash` and `set -euo pipefail` (exit on error, undefined variable, or failed pipe).
- Always quote variables (`"$FILE_PATH"`) to prevent word-splitting on spaces.
