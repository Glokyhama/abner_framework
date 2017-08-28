# abner_framew

## Service环境搭建

### 1.框架介绍

### 2.环境搭建

### 3.目录说明
##### 1.DO(Data Object) :与数据库表结构一一对应,通过 DAO 层向上传输数据源对象。
##### 2.DTO(Data Transfer Object) :数据传输对象, Service 和 Manager 向外传输的对象。
##### 3.BO(Business Object) :业务对象。可以由 Service 层输出的封装业务逻辑的对象。
##### 4.QUERY :数据查询对象,各层接收上层的查询请求。注:超过 2 个参数的查询封装,禁止使用 Map 类来传输。
##### 5.VO(View Object) :显示层对象,通常是 Web 向模板渲染引擎层传输的对象。




## Web环境搭建
### 1.安装nginx
安装gcc、g++依赖库
````
sudo apt-get install build-essential
sudo apt-get install libtool
````
安装pcre依赖库（http://www.pcre.org/）
````
sudo apt-get install libpcre3 libpcre3-dev
````
安装zlib依赖库（http://www.zlib.net）
````
sudo apt-get install zlib1g-dev
````
安装ssl依赖库（某些vps默认没装ssl）
````
sudo apt-get install openssl
````
安装nginx
````
sudo apt-get install nginx
````
启动nginx
````
# 80端口是否被占用
netstat -ano|grep 80

````


### 2.安装nodejs
````
sudo apt-get install nodejs
sudo apt-get install npm
sudo apt install nodejs-legacy
````
其他系统安装参考网址（http://www.runoob.com/nodejs/nodejs-install-setup.html）
### 3.安装grunt
````
sudo npm install -g grunt-cli
````
### 4.目录说明
````
/grunt 
/landing
/libs
/src
````
### 5.目录[webapp]执行如下命令：
````
npm install
grunt build:angular
npm start (注意：[npm start]时，依赖文件[package.json])
````


