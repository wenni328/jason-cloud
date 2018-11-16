# zuul使用

- 作为路由把控路径
- 整合swagger文档（一个路径多个api文档）
- turbine数据监控
-  回退/失败响应

# 配置
```yaml
spring:
  application:
    name: api-zuul

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8080/eureka/
server:
  port: 8085
zuul:
  routes:
     # 命名随意
     eureka-client:
     # 前缀
       path: /eureka/**
     # 对应的服务名
       service-id: eureka-client-blog
     feign-client:
       path: /feign/**
       service-id: feign-consumer
     server-mybatis:
       path: /server/**
       service-id: server-mybatis-plus
  host:
   # 每个主机初始连接数
    max-per-route-connections: 50
ribbon:
# Zuul使用的默认是Apache的HTTP Client 这里是开启 Rest Client
  restclient:
    enabled: true
swagger:
  base-package: com.api.gateway

# turbine.app-config	指定需要监控的servicename，多个service以,间隔
# turbine.combine-host-port	合并同一个host多个端口的数据
# turbine.cluster-name-expression	指定集群名称，默认为default，当设立了多个集群时，可以在Hystrix指定集群名称来查看监控
turbine:
  app-config: server-mybatis-plus ,eureka-client-blog,feign-consumer,api-zuul
  cluster-name-expression: new String("default")
  combine-host-port: true
  # https://blog.csdn.net/weixin_39080216/article/details/80784483
  # 下面这个属性是正确的 只是idea没有识别，作用是加入了actuator 访问路径变成了localhost:8085/actuator/hystrix.stream
  # 但是监控的路径是localhost:8085/hystrix.stream  这个就是去除前缀的作用
  instanceUrlSuffix: hystrix.stream
# zuul.prefix 我们可以指定一个全局的前缀
# strip-prefix: 是否将这个代理前缀去掉


```
# 数据监控效果图

![数据监控图](https://github.com/wenni328/jason-cloud/blob/cloud-base-rpc/cloud-base-rpc/spring-cloud-swagger-zuul/1.jpg)