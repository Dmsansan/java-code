## spring 源码分析
#### 1、spring轻量级的java-web应用开发框架

两大核心组件ioc aop

Data                      webSocket

数据持久层                 http web 访问 
orm jdbc                  webSocket servlet
                          web
                          
                 aop
               切面编程
core container 容器管理

IOC 控制反转 bean 对象实例 context 上下文

#### 2、jar包依赖分析
CORE

spring-core:依赖注入的IOC和DI的最基本实现

spring-beans:bean工厂和bean的装配

spring-context:spring的context上下文即IOC容器

spring-context-support

spring-expression:spring表达式      

AOP

spring-aop:面向切面编程

spring-aspects:集成aspects

spring-instrument:提供一些类级的工具实现以及ClassLoader,用于服务器

spring-instrument-tomcat:针对tomcat集成instruments