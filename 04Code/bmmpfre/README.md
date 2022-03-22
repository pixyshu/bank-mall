# bmmpfre
> 该项目为前后端分离项目的前端部分
>
> 主要参考项目：http://www.macrozheng.com/admin/

## 项目介绍

`mall-admin-web`是一个电商后台管理系统的前端项目，基于Vue+Element实现。主要包括商品管理、订单管理、会员管理、促销管理、运营管理、内容管理、统计报表、财务管理、权限管理、设置等功能。

### 技术选型

技术 | 说明 | 官网
----|----|----
Vue | 前端框架 | [https://vuejs.org/](https://vuejs.org/)
Vue-router | 路由框架 | [https://router.vuejs.org/](https://router.vuejs.org/)
Vuex | 全局状态管理框架 | [https://vuex.vuejs.org/](https://vuex.vuejs.org/)
Element | 前端UI框架 | [https://element.eleme.io/](https://element.eleme.io/)
Axios | 前端HTTP框架 | [https://github.com/axios/axios](https://github.com/axios/axios)
v-charts | 基于Echarts的图表框架 | [https://v-charts.js.org/](https://v-charts.js.org/)
Js-cookie | cookie管理工具 | [https://github.com/js-cookie/js-cookie](https://github.com/js-cookie/js-cookie)
nprogress | 进度条控件 | [https://github.com/rstacruz/nprogress](https://github.com/rstacruz/nprogress)
vue-element-admin | 项目脚手架参考 | [https://github.com/PanJiaChen/vue-element-admin](https://github.com/PanJiaChen/vue-element-admin)

### 项目布局

``` lua
src -- 源码目录
├── api -- axios网络请求定义
├── assets -- 静态图片资源文件
├── components -- 通用组件封装
├── icons -- svg矢量图片文件
├── router -- vue-router路由配置
├── store -- vuex的状态管理
├── styles -- 全局css样式
├── utils -- 工具类
└── views -- 前端页面
    ├── home -- 首页
    ├── layout -- 通用页面加载框架
    ├── login -- 登录页
    ├── oms -- 订单模块页面
    ├── pms -- 商品模块页面
    └── sms -- 营销模块页面
```

## 搭建步骤

### 环境要求

- 下载node12.x并安装：[https://nodejs.org/dist/v12.14.0/node-v12.14.0-x64.msi](https://nodejs.org/dist/v12.14.0/node-v12.14.0-x64.msi);
- 启动本地redis-server，不需要配密码

<br>

### 启动后台项目

- 切换项目环境

  ![image-20220322132737533](https://cdn.jsdelivr.net/gh/pixyshu/picgo@main/image/20220322132738.png)

- 启动后台服务

  - 启动`AuthorityApplication`：认证服务
  - 启动`GatewayApplication`：网关服务
  - 启动`UserAdminApplication`：用户登录注册管理服务

  ![image-20220322131307728](https://cdn.jsdelivr.net/gh/pixyshu/picgo@main/image/20220322131309.png)

- 服务启动成功，可以在

<br>

### 启动前端项目

- 建议使用`VS Code`打开项目
  - ![image-20220322130409444](https://cdn.jsdelivr.net/gh/pixyshu/picgo@main/image/20220322130410.png)

- 打开终端，执行`npm install`安装依赖包，再执行`npm run dev`启动前端项目

- > `注意`：如果遇到`npm install`无法成功下载依赖，可以尝试执行以下命令：

```shell
# 先把原来的依赖删掉
npm uni node-sass

# 重新下载依赖
npm i node-sass

#执行完上面两行再执行
npm i

# 执行运行命令
npm run dev
```



## 许可证

[Apache License 2.0](https://github.com/macrozheng/mall-admin-web/blob/master/LICENSE)

Copyright (c) 2018-2022 macrozheng
