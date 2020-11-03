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