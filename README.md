# bank-mall

## 项目简介

### 仓库文件夹介绍



<img src="https://cdn.jsdelivr.net/gh/pixyshu/picgo@main/image/20220307113034.png" alt="image-20220307113033972" style="zoom:50%;" />





### 项目缩写说明

> bank-mall-management-platform：银行商场管理平台

- 服务端项目缩写：bmmp
- 管理平台前端项目缩写：bmmpfre
- 客户端前端项目缩写：bmfre

### bmmp项目模块介绍

```xml
bmmp            #聚合工程，用于聚合bmmp-common、bmmp-parent、bmmp-platform
├── bmmp-common				 # 通用服务包
├── bmmp-domain				 # 具体业务服务
	├── bmmp-domain-demo				 # 权限服务父工程
	├── bmmp-domain-user				 # 用户管理服务
	├── bmmp-domain-XXX			 	   # XX服务
├── bmmp-parent				 # 依赖管理父项目
└── bmmp-platform			 # 支撑服务
	├── bmmp-gateway-authority		# 授权服务
	├── bmmp-gateway-gateway		  # 网关服务
	├── bmmp-gateway-XXX		 			# XX服务
```



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

<br>



### 工作区和暂存区

`git status`：可以查看当前版本库存在什么修改操作，以及这些修改发生在什么阶段（工作区、暂存区、版本库分支）

#### 

![git-repo](https://www.liaoxuefeng.com/files/attachments/919020037470528/0)

文件往Git版本库里添加的时候，分两步执行：

- 第一步是用`git add`把文件添加进去，实际上就是把文件修改添加到暂存区；

- 第二步是用`git commit`提交更改，实际上就是把暂存区的所有内容提交到当前分支。



### 基本用例

#### 如何提交代码？

1）将本地修改添加到本地版本库

- `git add .`：添加本地有修改过的文件到暂存库

- `git commit -m "新增/修改了XXX功能"` ：提到修改到本地版本库

2）更新远程代码到本地仓库

- `git pull origin dev` ：将远程库`dev`分支下的代码拉取到本地仓库

这要做的目的，主要是预防本地代码和远程仓库的代码之间出现冲突，导致不能本地不能够代码到远程仓库。

主要还是希望，通过更新远程代码，如果出现冲突，都在本地就解决，然后再提交到远程仓库

3）将本地版本库代码推送到远程仓库

- `git push origin dev`：将本地仓库代码推送到远程仓库的`dev`分支下面

4）使用案例

<img src="https://cdn.jsdelivr.net/gh/pixyshu/picgo@main/image/20220316193039.png" alt="image-20220316193038079" style="zoom:57%;" />



<br>

#### 如何删除远程版本库里面的文件(夹)？

1）更新远程仓库到本地仓库

- `git pull origin dev`

2）删除文件或者文件夹

- `git rm file`：删除版本库中的文件
- `git rm -r drectory`：删除版本库中的文件夹

3）提交修改

- `git commit -m "delete some files"`：提交删除文件操作的说明

4）将修改提交到远程仓库

- `git push origin dev`

<br>

#### 如何处理版本冲突?

一般我们的在提交代码钱都需要把远程的代码达到本地，如果远端代码和我们本地的文件有冲突。

那我们都是在本地先冲突再`push`到远程仓库，因此，非必要修改文件，尽量不动就不动，避免出现冲突处理。





