#!/usr/bin/env bash
set -e
ENDPOINT="http://localhost:4566"
QUEUE_URL=$(aws --endpoint-url=$ENDPOINT sqs create-queue --queue-name order-events-queue --query 'QueueUrl' --output text)
aws --endpoint-url=$ENDPOINT sqs send-message --queue-url "$QUEUE_URL" --message-body '{"orderId": 101, "status": "CREATED"}'
aws --endpoint-url=$ENDPOINT sqs receive-message --queue-url "$QUEUE_URL"
