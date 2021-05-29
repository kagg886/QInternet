# QInternet
 QInternet是有一个以中转消息为主的QQ框架。
 其目的便于快速移植代码到别的QQBot客户端，免受重构的痛苦。
 
## 如何编写QInternet
1.实现一个类，这个类推荐实现kagg886.qinternet.Interface.QQMsgListener接口。
2.重写其所有方法。
## 如何接入QInternet(以接入群消息为例)
1.在bot客户端提供的初始化接口里声明并实现GroupAPI。
2.使用构造函数封装Group Member对象
3.构造GroupMsgPack对象，并传入前文的方法里
