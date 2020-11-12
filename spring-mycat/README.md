## spring-boot+中间件mycat实现分库分表

####1、垂直拆分

​		将数据表的字段进行拆分，使用join关联拆分的数据表。

​		拆分前：col1 col2 col3 col4 col5 col6 col7 col8

​		拆分后：col1 col2 col3 col4

​						col5 col6 col7 col8

####2、水平拆分

​		将数据量较大的表按一定的规则横向切割，id%2(切割表的个数)。

​		拆分前：col1 col2 col3 col4 col5 col6 col7 col8

​		拆分后：col1 col2 col3 col4 col5 col6 col7 col8

​						id%2=1

​						col1 col2 col3 col4 col5 col6 col7 col8

​						id%2=0

#### 3、mycat 1.6配置

* conf/schema.xml

  主要配置mycat服务提供的schema, 关联的mysql数据库服务地址，以及数据库表的信息；

* conf/server.xml

  主要配置连接mycat服务的账号密码信息；

* conf/rule.xml

  主要配置数据表的拆分规则；

####4、ps：注意事项

* 1、默认端口是8066
* 2、需要指定mysql-connector-javaI依赖版本