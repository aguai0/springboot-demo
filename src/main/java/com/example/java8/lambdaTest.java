package com.example.java8;


import jdk.management.resource.ResourceId;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.IntBinaryOperator;

public class lambdaTest {

    public static void main(String[] args) {
        IFunction function1 = new IFunction() {

            @Override
            public String getNameById(Long id) {
                return "id";
            }
        };
        LocalDateTime.now().minusYears(1L).with(TemporalAdjusters.lastDayOfYear());

        Consumer<IFunction> iFunctionConsumer = (IFunction f) -> f.getNameById(1L);
        iFunctionConsumer.accept(function1);

        IntBinaryOperator intBinaryOperator = (int x, int y) -> x + y;//接收x和y两个整形参数并返回他们的和
        intBinaryOperator.applyAsInt(1,2);

        ResourceId resourceId = () -> "66";
        DoubleSupplier doubleSupplier = () -> 66;  //不接收任何参数直接返回66
        Consumer<String> stringConsumer = (String name) -> {
            System.out.println(name);//接收一个字符串然后打印出来
        };
    }
}