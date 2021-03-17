#!/bin/bash

curl -XPOST "localhost:9200/index_name/_search?pretty" \
-H 'Content-Type: application/json' \
-d'{
  "query": {
      "term": {
        "field-term": {
        "value": "field-value"
        }
      }
  },
  "size": 0,
  "aggs": {
    "my_buckets": {
      "composite": {
        "size": 2,
        "sources": [
          { "term1": { "terms": { "field": "term1.keyword", "order": "asc" } } },
          { "term2": { "terms": { "field": "term2.keyword", "order": "asc" } } }
        ],
        "after" : {"term1" : "value"}
        }
    }
  }
}
