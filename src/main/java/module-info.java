open module techzealot.java.playground {
    exports com.techzealot.examples.features.records;
    exports com.techzealot.examples.features.sealeds;
    exports com.techzealot.examples.features.vectors;
    requires com.google.common;
    requires jdk.incubator.vector;
    requires jdk.incubator.foreign;
    //声明自动模块引用:jar包去除版本号
    //requires hutool.all;
}