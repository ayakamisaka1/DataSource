# redis
docker run --name my-redis -d -p 6379:6379 -e REDIS_PASSWORD=XSJroot123456 --memory 256m redis
# mysql
docker run --name mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7