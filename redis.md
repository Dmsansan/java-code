1.获取redis资源

　　wget http://download.redis.io/releases/redis-4.0.8.tar.gz

2.解压

　　tar xzvf redis-4.0.8.tar.gz

3.安装

　　cd redis-4.0.8

　　make

　　cd src

　　make install PREFIX=/usr/local/redis

4.移动配置文件到安装目录下

　　cd ../

　　mkdir /usr/local/redis/etc

　　mv redis.conf /usr/local/redis/etc

 5.配置redis为后台启动

　　vi /usr/local/redis/etc/redis.conf //将daemonize no 改成daemonize yes

6.将redis加入到开机启动

　　vi /etc/rc.local //在里面添加内容：/usr/local/redis/bin/redis-server /usr/local/redis/etc/redis.conf (意思就是开机调用这段开启redis的命令)

7.开启redis

　　/usr/local/redis/bin/redis-server /usr/local/redis/etc/redis.conf 

 

常用命令　　

　　redis-server /usr/local/redis/etc/redis.conf //启动redis

　　pkill redis  //停止redis

　　卸载redis：

　　　　rm -rf /usr/local/redis //删除安装目录

　　　　rm -rf /usr/bin/redis-* //删除所有redis相关命令脚本

　　　　rm -rf /root/download/redis-4.0.4 //删除redis解压文件夹

8.操作redis


　　进入src 执行./redis-cli

	127.0.0.1:6379> set foo bar
	OK
	127.0.0.1:6379> get foo
	"bar"
	127.0.0.1:6379> exit
