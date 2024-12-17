#!/usr/bin/env bash
# Wait for a service to become available

host="$1"
port="$2"
timeout="${3:-30}"

echo "Waiting for $host:$port to be available..."

for i in $(seq 1 $timeout); do
  nc -z "$host" "$port" && break
  echo "Waiting... ($i/$timeout)"
  sleep 1
done

if [ $i -eq $timeout ]; then
  echo "Timeout reached while waiting for $host:$port"
  exit 1
fi

echo "$host:$port is available"
exec "${@:4}"
