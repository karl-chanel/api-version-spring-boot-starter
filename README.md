### 原[repo](https://github.com/lkqm/spring-api-versioning/blob/main/README.md?plain=1) 不支持springboot3,此repo为修改依赖(jarkata ee)适配spring boot3版本，老版本请用原repo



Simple development of multi-version api based on spring-mvc via @ApiVersion annotation, support for uri, header, param.

Supports: JDK 17+, spring-boot 3.x

## Features
- URI:  /v1/user/list, /v2/user/list
- Header: /user/list, header: X-API-VERSION=1
- Param:  /user/list?api_version=1

Important: version number use precise matching with String equals method.

## Quick
1. Add Dependency(Maven)
    ```
     <dependency>
        <groupId>io.github.karl-chanel</groupId>
        <artifactId>api-version-spring-boot-starter</artifactId>
        <version>1.0.0</version>
    </dependency>
  
    ```
    
2. @EnableApiVersioning with Application class
    ```
    @SpringBootApplication
    @EnableApiVersioning
    public class Application {
        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }
    }
    ```

3. Controller
    ```
    @RestController
    @RequestMapping("/user")
    @ApiVersion("1")
    public class UserController {
    
        @GetMapping("/list")
        public String list1() {
            return "list1";
        }
    
        @GetMapping("/list")
        @ApiVersion("1.1")
        public String list2() {
            return "list2";
        }
    }
    ```
4. Test
    ```
    curl http://127.0.0.1:8080/v1/user/list
    curl http://127.0.0.1:8080/v1.1/user/list
    ```


## Config properties
```
api.version.type=uri                # versioning implement way: uri(default), header, param
api.version.uri-prefix=             # uri prefix, if set /api, request uri like: /api/v1/... /api/v2/...
api.version.uri-location=           # uri version location: begin(/v1/user/list), end(/user/list/v1)
api.version.header=X-API-VERSION    # version control http header name
api.version.param=api_version       # version control http query string name
```
