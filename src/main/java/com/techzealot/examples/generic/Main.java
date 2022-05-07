package com.techzealot.examples.generic;

import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Countable<Counter> c=new MergedCountable<>();
        int count = c.count(List.of(new OneCounter(), new FiveCounter()));
        System.out.println(count);
        //error 泛型不变
        //Countable<Counter> countable=new MergedCountable<FiveCounter>();
        //error 逆变
        //consumer.andThen((Integer ii)-> System.out.println(ii));
        //示例
        Consumer<Number> c1= (i -> System.out.println(i));
        Consumer<Number> c2 = c1.andThen((Object ii) -> System.out.println(ii));
        c2.accept(10);
    }
}
