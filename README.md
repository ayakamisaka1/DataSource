# redis
docker run --name my-redis -d -p 6379:6379 --memory 256m -v /path/to/redis_data:/home/redis redis --requirepass "XSJroot123456"
# mysql
docker run --name mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7