# bank-mall

## 项目简介

### 仓库文件夹说明

> / 01Plan
>
> / 02Requirement：产品需求分析文档存放在这里
>
> / 03Design
>
> ​	/ **01mind**：功能架构设计的导图放在这里
>
> ​	/ **02UI**：功能设计的原型图文件放在这里
>
> ​	/ **03pdm**：数据库设计的物理模型文件放在这里
>
> ​	/ **04sql**：数据库的表单生成脚步放在这里
>
> / 04Code
>
> ​	/ **bmmp**：服务端的后端项目文件
>
> ​	/ **bmmpfre**：管理端的前端项目文件
>
> ​	/ **bmfre**：客户端的前端项目文件



### 项目缩写说明

> bank-mall-management-platform：银行商场管理平台

- 服务端项目缩写：bmmp
- 管理平台前端项目缩写：bmmpfre
- 客户端前端项目缩写：bmfre

<br>

## 知识共享

### 工作协作平台

- [Jira](https://shuisheng.atlassian.net/jira/software/projects/SCRUM/boards/2/roadmap?shared=&atlOrigin=eyJpIjoiNjdiMjA4NWZiMzgxNGIxMzljMDYxNGY0Y2JmNjQ3YmEiLCJwIjoiaiJ9)


![image-20220305153616775](https://cdn.jsdelivr.net/gh/pixyshu/picgo@main/image/20220305153618.png)



### 参考项目

后台管理端参考项目：[mall-admin-web 商场管理平台](https://github.com/macrozheng/mall-admin-web)（账户：`admin`，密码：`macro123`）

秒杀客户端参考项目：[icyfenixBookstore 书店在线平台](https://bookstore.icyfenix.cn/#/)（账户密码任意即可）

京东秒杀参考：[京东秒杀](https://miaosha.jd.com/)

<br>

### 技术文档

- [git教程——廖雪峰](https://www.liaoxuefeng.com/wiki/896043488029600)：有文字、有图片还有视频的git在线教程

- [mall学习教程](http://www.macrozheng.com/#/?id=mall学习教程)：一个涵盖了各种技术栈的实现的文档

- [EasyCode的自定义配置和使用](https://www.cnblogs.com/shuds/articles/15968119.html)：自定义EasyCode的模版，实现生成符合我们项目需求的业务代码自动生成脚手架

<br>

## 分支策略

在实际开发中，我们应该按照几个基本原则进行分支管理：

首先，`master`分支应该是非常稳定的，也就是仅用来发布新版本，平时不能在上面干活；

其次，每个人都在`dev`分支上干活，每个人都有自己的分支，时不时地往`dev`分支上合并就可以了。

<img src="https://cdn.jsdelivr.net/gh/pixyshu/picgo@main/image/20220303154315.png" alt="image-20220303154308361" style="zoom:50%;" />



> ⚠️注意：我们都在dev分支上工作，拉取dev分支上的代码，将本地的工作都提交到dev分支上。
>



