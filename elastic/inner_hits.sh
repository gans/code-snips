#!/bin/bash

curl -XPOST "localhost:9200/index_name/_search?pretty" \
-H 'Content-Type: application/json' \
-d'{
  "size": 1,
  "query": {
    "match_all": {}
  },
  "collapse": {
    "field": "field.keyword",
    "inner_hits": {
      "name": "most_recent",
      "size": 10,
      "sort": [{"timestamp": "desc"}]
    }
  }
}'
