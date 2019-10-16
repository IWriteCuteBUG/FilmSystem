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
订单模块(guns_order):tomcat 8083,dubbo 20883
支付模块(guns_pay):tomcat 8084,dubbo 20884

我们可爱的组员
邓海东 唐辉武 李佳伟 孙佳宝

打杂人员
赵宇鹏

很可惜之前的仓库都没有任何会议记录

用户模块的登录部分整合redis有点做头

订单的显示也有其特点

这个项目虽然不完善，但是好在比较全一点

订单跟支付的四个接口都有做的意义，登录接口也有点意义
