## 本库说明
本库用于手机状态栏和虚拟导航栏的设置；支持透明状态栏、设置状态栏颜色等；

## 引入说明
在对应模块（Module）的build.gradle中添加依赖
```
implementation("io.github.uni-cstar:okSysBar:1.0.2")
```

## 功能说明
其中StatusBar相关的方法用于设置状态栏；NavigationBar用于设置底部导航栏；SystemBar表示同时设置状态栏和状态栏

- 支持设置状态栏颜色（混色）、透明模式（沉浸式）、浅色/深色模式；
- 支持设置底部导航栏颜色、透明模式（沉浸式）
- 提供一个名为`StatusBarFakerView`并且与状态栏等高的自定义View，用于需要在xml布局中替代状态栏区域的场景；

虚拟导航栏的控制与状态栏的控制很相似，具体细节查看源文件`OkSysBar`。

#### 1、修改状态栏颜色
通过`OkSysBar#setStatusBarColor`方法修改状态栏颜色，状态栏不会覆盖用户布局；

#### 2、沉浸式状态栏
通过`OkSysBar#setImmersiveStatusBar`方法设置透明状态栏并修改状态栏颜色；状态栏内容**会覆盖**在用户布局之上；

#### 3、状态栏浅色模式或深色模式
- 设置状态栏浅色模式（即状态栏背景为浅色、文字为深色（比如黑色））：`Activity#setStatusBarLightMode`
- 设置状态栏深色模式（即状态栏背景为深色、文字为浅色（比如白色））：`Activity#setStatusBarDarkMode`

#### 4、修改虚拟导航栏颜色&设置沉浸式导航栏
导航栏操作类似状态栏，不赘述，查看包含NavigationBar相关的方法即可实现。

#### 5、同时修改状态栏和导航栏颜色或设置沉浸式模式
查看包含SystemBar相关的方法即可实现。