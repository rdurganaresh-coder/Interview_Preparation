#!/usr/bin/env bash
set -e
ENDPOINT="http://localhost:4566"
aws --endpoint-url=$ENDPOINT s3 mb s3://mastery-practice-bucket
echo "Hello LocalStack S3" > /tmp/sample.txt
aws --endpoint-url=$ENDPOINT s3 cp /tmp/sample.txt s3://mastery-practice-bucket/sample.txt
aws --endpoint-url=$ENDPOINT s3 ls s3://mastery-practice-bucket
