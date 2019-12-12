# markdown


# 数学表示
  中文<sup>上标</sup>   中文 <sub>下标</sub> 


## 流程图

​```flow
    st=>start: 开始
    e=>end: 结束
    op=>operation: 操作
    sub=>subroutine: 子程序
    cond=>condition: 是或者不是?
    io=>inputoutput: 输出

    st(right)->op->cond
    cond(yes)->io(right)->e
    cond(no)->sub(right)->op
​```

## 类图

@startuml
Title "BundleLauncher类图"
interface BundleExtractor
abstract class BundleLauncher
abstract class SoBundleLauncher
abstract class AssetBundleLauncher

BundleLauncher <|-- ActivityLauncher
BundleLauncher <|-- SoBundleLauncher
SoBundleLauncher <|-- ApkBundleLauncher
BundleExtractor <|.. SoBundleLauncher
SoBundleLauncher <|-- AssetBundleLauncher
AssetBundleLauncher <|-- WebBundleLauncher

class ActivityLauncher {
+ public preloadBundle(Bundle bundle)
}

class SoBundleLauncher {
+ public preloadBundle(Bundle bundle)
}

class ApkBundleLauncher {
+ public loadBundle(Bundle bundle)
}

class AssetBundleLauncher {
+ public loadBundle(Bundle bundle)
}
@enduml
