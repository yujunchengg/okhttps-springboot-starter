# okhttps-springboot-starter

#### 介绍
springboot自定义starter，封装okhttp，方便在springboot项目中使用okhttp发送各种http请求
目前1.0版本暂时只简单封装了同步请求

#### 软件架构
软件架构说明
springboot+okhttp
#### 使用说明

1.  clone本工程到本地计算机
2.  切换到工程根目录,执行mvn打包命令: mvn clean install,将该starter安装到本地的maven库
3.  自己的springboot工程通过引入该starter,使用该starter中定义的GetTemplate,PostTemplate,PutTemplate,DeleteTemplate
    具体使用详情如下:
    ```
    <dependency>
        <groupId>com.qingbeijy</groupId>
        <artifactId>okhttps-springboot-starter</artifactId>
        <version>1.0</version>
    </dependency>
    ```
4.  可以在springboot工程中的application.yml文件中添加okhttps组件的一些配置参数,主要用于对建立的Http连接做一些参数调整
    ```
    starter:
      okhttps:
        connectTimeout: 10s             #连接超时时间
        read-timeout: 500ms             #数据读取超时时间
        writeTimeout: 500ms             #写数据超时时间
        max-idle: 100                   #最大空闲连接
        base-url: http://127.0.0.1:8200 #请求url前缀
        pool:
          max-idle-connections: 10      #最大空闲连接数   
          keep-alive-duration: 5        #连接保活时间
          time-unit: minutes            #连接保活时间的单位
    ```  

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 码云特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5.  码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
