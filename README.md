# SRouterDemo
![](https://img.shields.io/badge/release-0.0.1-brightgreen.svg)
## 使用

在你的项目根工程bulid.gradle中添加，让所有工程都依赖SRouter

```gradle
compile 'com.sarlmoclen.router:SRouter:0.0.1'
```

使用SApplication自定义自己的Application，主要是为了注册每个模块的消息通道，其中registerAction函数第一个参数定义的是通道名称，第二个是消息通道

```java
 public class MyApplication extends SApplication{

    @Override
    public void registerAction() {
        SRouter.getInstance().registerAction(OneActionName.name, new OneAction());
        SRouter.getInstance().registerAction(TwoActionName.name, new TwoAction());
        SRouter.getInstance().registerAction(MainActionName.name, new MainAction());
        SRouter.getInstance().registerAction(ThreeActionName.name, new ThreeAction());
    }

}
 ```
 
自定义自己模块的消息通道，其中requestData为通道传递的数据

```java
public class OneAction extends SAction{

    @Override
    public Object startAction(Context context, HashMap<String, Object> requestData) {
        if(context instanceof Activity){
            Intent i = new Intent(context, ChildActivity.class);
            i.putExtra("from",requestData.get("from").toString());
            context.startActivity(i);
        }else{
            Intent i = new Intent(context, ChildActivity.class);
            i.putExtra("from",requestData.get("from").toString());
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
        return "arrive one success!";
    }

}
```
 
调用开启通道传递数据

```java
SRouterResponse mSRouterResponse = SRouter.getInstance().sendMessage(
                    ChildActivity.this, SRouterRequest.creat()
                            .action(OneActionName.name)
                            .data("from","from main"));
 ```

## 框架设计原理

常规开发中，两个模块要实现相互调用，就需要相互依赖，然后才可以调起对方的程序，这种开发模式很容易造成程序
耦合度增加，后期很难维护，为了解决这个问题，参考路由的方式，建立路由器控制程序，所有的模块不再相互依赖，
而是都依赖这个路由器，通过路由器框架来处理所有模块之间的通信，这样就实现了模块之间的解耦。

## 框架流程图

![image](https://github.com/sarlmoclen/SRouterDemo/blob/master/1499311950.jpg)

## 流程图讲解
 * SRouter
 	* 路由框架功能实现部分，其中SRouter.java为核心控制程序，通过HashMap<String, SAction> mActions
（HashMap的查询时间复杂度是O(1)）这种形式，注册每个module的消息通道，key为消息通道的名字，value为
消息通道的执行部分action。 使用者传入要操作的通道名字，就可以去操作通道的执行部分action。
 * Common
 	* 这里可以放一些公共类，目的是为了把路由框架独立出来，这里建议把每个通道的名字key放在这里做统一管理。
 * AppChildOneSameProcess
 	* 跟AppMain同进程的module，用来测试同进程下每个模块的相互调用。
 * AppChildTwoSameProcess
 	* 跟AppMain同进程的module，用来测试同进程下每个模块的相互调用。
 * AppChildThreeDifferentProcess
 	* 跟AppMain不同进程的module，用来测试不同进程下每个模块的相互调用。
 * AppMain
 	* 程序入口module，这里要提前注册所有的消息通道，在application中注册。

## 路由框架支持
 * 支持单进程和多进程情况下的消息通道使用，单进程就不说了，主要讲解下多进程的支持原理：消息通道的注册是在
application中注册，所以多进程下会给每个进程注册一份相同的消息通道队列，这样就可以每个进程都可以调起action,
然后依赖intent(支持多进程通信),把要传递的消息传过去，有人问如果有情况不能使用intent怎么办，作者考虑到，多
进程目前android系统针对的是四大组件，刚好intent也针对的是四大组件，既然系统已经有很好的方案，就不需要自己
再去单独实现一份多进程通信了，如果后期有特殊要求，可以用aidl实现多进程情况下的通信。
 * 可以针对单独模块做单独测试，我们可以自己写test module,代替AppMain打包模块测试包。
 * 解耦，这也是这个框架的目的，这种设计模式可以避开模块相互依赖导致代码耦合度增加，除了AppMain这个模块，其他
模块之间是单独独立的，遇到模块之间的通信，都用SRouter来实现交互，我们在开发中可以为每个开发小组分配独立的module
实现并行开发。

## License
The Apache Software License, Version 2.0  [LICENSE](http://www.apache.org/licenses/LICENSE-2.0.txt)
