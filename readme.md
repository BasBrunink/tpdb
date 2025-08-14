


After container is up, run the following commands:
```
docker exec -it tpdb_postgres psql -U tpdb_user -c "CREATE DATABASE tpdb;"
docker exec -it tpdb_postgres psql -U tpdb_user -c "CREATE DATABASE keycloak;"

```