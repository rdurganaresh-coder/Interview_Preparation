#!/usr/bin/env bash
set -euo pipefail

SOURCE_DIR="${1:-../sample-logs}"
BACKUP_DIR="${2:-/tmp/mastery-backups}"
RETENTION_DAYS=7

mkdir -p "$BACKUP_DIR"
TIMESTAMP=$(date +"%Y%m%d_%H%M%S")
ARCHIVE_PATH="$BACKUP_DIR/backup_${TIMESTAMP}.tar.gz"

tar -czf "$ARCHIVE_PATH" -C "$(dirname "$SOURCE_DIR")" "$(basename "$SOURCE_DIR")"
echo "Created backup: $ARCHIVE_PATH"

# Delete backups older than RETENTION_DAYS
find "$BACKUP_DIR" -name "backup_*.tar.gz" -type f -mtime +${RETENTION_DAYS} -delete
echo "Cleaned backups older than ${RETENTION_DAYS} days."
