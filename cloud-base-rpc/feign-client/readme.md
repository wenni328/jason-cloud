# 说明
使用feign消费服务。fengi内置也是使用了eureka，但是差别还是很大的。
个人比较喜欢feign消费方式，简洁。
# 配置
```properties
spring.application.name=feign-consumer
server.port=8083
eureka.client.serviceUrl.defaultZone=http://localhost:8080/eureka/
swagger.base-package=com.cloud.feign.controller

```
# 使用方式
```java

@FeignClient("server-mybatis-plus")
public interface AuthFeignClient {

    @GetMapping(value = "/server/list",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<User> getuserinfo();
}
```