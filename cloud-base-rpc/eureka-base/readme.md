# 说明
空壳子一个，实际项目中只作为一个注册中心一样的存在，不注册本身。其他
服务都注册在这里。

# 配置
```yaml

server:
  port: 8080

eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/

```