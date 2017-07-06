# SRouterDemo
android路由框架SRouter
# 框架流程图
![image](https://github.com/sarlmoclen/SRouterDemo/blob/master/1499311950.jpg)
# 流程图讲解
    【SRouter】
    
        路由框架功能实现部分，其中SRouter.java为核心控制程序，通过HashMap<String, SAction> mActions（HashMap的查询时间复杂度是O(1)）
    这种形式，注册每个module的消息通道，key为消息通道的名字，value为消息通道的执行部分action。 使用者传入要操作的通道名字，就可以去操作
    通道的执行部分action。
             
    【Common】
    
        这里可以放一些公共类，目的是为了把路由框架独立出来，这里建议把每个通道的名字key放在这里做统一管理。
        
    【AppChildOneSameProcess】
    
        跟AppMain同进程的module，用来测试同进程下每个模块的相互调用。
        
    【AppChildTwoSameProcess】
    
        跟AppMain同进程的module，用来测试同进程下每个模块的相互调用。
        
    【AppChildThreeDifferentProcess】
    
        跟AppMain不同进程的module，用来测试不同进程下每个模块的相互调用。
        
    【AppMain】
    
        程序入口module，这里要提前注册所有的消息通道。
