# 说明
eureka消费，使用方式：如下
# 使用方式http
```java
 @Autowired
    @Qualifier("restTemplatePlus")
    RestTemplate restTemplate;
    @Autowired
    LoadBalancerClient loadBalancerClient;

    public Object hiService() {
        log.info("123");
        //返回是String--之前是User，一直都出错server-mybatis-plus
        String json=restTemplate.getForObject("http://SERVER-MYBATIS-PLUS/server/list",String.class);
        List<User> list=JSONObject.parseArray(json,User.class);
        for (User u:list) {
            log.info(JSONObject.toJSONString(u));
        }
        return json;
    }
```
# 配置
```yaml
server:
  port: 8082

spring:
  application:
    name: eureka-client-blog

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8080/eureka/

swagger:
  base-package: com.cloud.eureka.client.controller
```