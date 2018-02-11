# shiro应用

## shiro概述
### 认证
### 授权
### 加密
### 会话管理
### web集成

## shiro定义

### 概念
   * Subject :翻译为主角，当前参与应用安全部分的主角。可以是用户，可以试第三方服务，可以是cron 任务，或者任何东西。主要指一个正在与当前软件交互的东西。
              所有Subject都需要SecurityManager，当你与Subject进行交互，这些交互行为实际上被转换为与SecurityManager的交互
   * SecurityManager :安全管理员，安全管理员，Shiro架构的核心，它就像Shiro内部所有原件的保护伞。然而一旦配置了SecurityManager，SecurityManager就用到的比较少，开发者大部分时间都花在Subject上面。

   * Realms :Realms作为Shiro和你的应用的连接桥，当需要与安全数据交互的时候，像用户账户，或者访问控制，Shiro就从一个或多个Realms中查找。

   * Authentication: 认证

   * Authorization:授权

   * session Manager: 会话管理
## shiro原理

## 应用流程

   * 1.导包
   * 2.配置web.xml
   * 3.配置shiro容器用spring-shiro.xml的Spring配置
   *
   *
   *
   *

## shiro认证流程

## shiro可复写API

## shiro和spring-security 比较