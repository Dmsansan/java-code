## 实时的分布式消息订阅系统Kafka入门指南

#### 1、kafka的安装过程
 
 * 1、1 下载
 
    在apache-kafka官方网站：http://kafka.apache.org/downloads，下载kafka的linux系统压缩包，这里选择
    kafka-2.5.0版本：
    ![](./doc/images/kafka_001.png)
    
 * 1、2 安装
 
    将压缩包上传到linux服务器对应目录下，解压。   
    ![](./doc/images/kafka_002.png)
    
 * 1、3 配置
 
    本次使用的是kafka的最新版本，自带有zookeeper注册中心，因此沿用的都是软件的默认配置。
    
#### 2、Linux环境下kafka的使用

 * 2、1 启动
 
        ./gradlew jar -PscalaVersion=2.12.10  