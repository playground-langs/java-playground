package com.techzealot.examples.generic;

import java.util.List;

/**
 * 此处只能声明不变的泛型 声明点只能使用不变泛型
 *  ? extends T 表示协变
 *  ? super T 表示逆变
 * @param <T>
 */
public interface Countable<T extends Counter> {
    int count(List<T> inputs);

    /**
     * 使用点协变
     * @param list
     */
    default void coviarance(List<? extends T> list){
        Counter counter = list.get(0);
        //error无法写入
        //list.add(new FiveCounter());
    }

    /**
     * 使用点逆变
     * @param list
     */
    default void contraviarance(List<? super Counter> list){
        //只能获取顶级父类型Object
        list.add(new FiveCounter());
        //可以写入
        Object object = list.get(0);
    }
}
