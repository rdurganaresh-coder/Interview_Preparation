#!/usr/bin/env bash
set -e
ENDPOINT="http://localhost:4566"
aws --endpoint-url=$ENDPOINT dynamodb create-table   --table-name CustomerOrders   --attribute-definitions AttributeName=CustomerId,AttributeType=S AttributeName=OrderId,AttributeType=S   --key-schema AttributeName=CustomerId,KeyType=HASH AttributeName=OrderId,KeyType=RANGE   --billing-mode PAY_PER_REQUEST
