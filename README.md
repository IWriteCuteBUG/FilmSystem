# FilmSystem
这个系统不卖电影票

测试连接
影院：http://localhost/test/cinema
用户：http://localhost/test/user
电影：http://localhost/test/film

已经占用的端口号
网关模块(guns_gateway):tomcat 80
用户模块(guns_user)：tomcat 8080,dubbo 20880
影院模块(guns_cinema)：tomcat 8081,dubbo 20881
电影模块(guns_film)：tomcat 8082,dubbo 20882
接口模块(guns_api):不占用端口号
