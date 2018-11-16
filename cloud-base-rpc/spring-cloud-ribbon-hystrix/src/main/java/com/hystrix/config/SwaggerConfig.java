//package com.hystrix.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import springfox.documentation.swagger.web.SwaggerResource;
//import springfox.documentation.swagger.web.SwaggerResourcesProvider;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author: xieyong
// * @date: 2018/11/13 17:20
// * @Description:
// */
//@Configuration
//@Primary
//public class SwaggerConfig implements SwaggerResourcesProvider {
//    @Override
//    public List<SwaggerResource> get() {
//        List resources = new ArrayList();
//        resources.add(swaggerResource("ribbon-hystrix", "/v2/api-docs", "2.0"));
//        resources.add(swaggerResource("service-b", "/swagger-service-b/v2/api-docs", "2.0"));
//        return resources;
//    }
//    private SwaggerResource swaggerResource(String name, String location, String version) {
//        SwaggerResource swaggerResource = new SwaggerResource();
//        swaggerResource.setName(name);
//        swaggerResource.setLocation(location);
//        swaggerResource.setSwaggerVersion(version);
//        return swaggerResource;
//    }
//}
