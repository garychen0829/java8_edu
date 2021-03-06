# java 8 新特性学习

+ Lambda 表达式
+ 函数式接口
+ 方法引用与构造器引用
+ Stream API
+ 接口中的默认方法与静态方法
+ 新时间日期API
+ 其他新特性

# java 8 新特性的优点

+ 速度更快
+ 代码更少（增加了新的语法Lambda 表达式）
+ 强大的Stream API
+ 便于并行
+ 最大化减少空指针异常Optional

---

## Lambda 表达式
Lambda 是一个匿名函数，可以把Lambda 表达式理解为是一段可以传递的代码（将代码像数据一样进行传递）。可以写出更简洁、更灵活的代码。作为一种更紧凑的代码风格，使Java的语言表达能力得到了提升。
## 函数式接口
+ 只包含一个抽象方法的接口，称为函数式接口。
+ 可以通过Lambda 表达式来创建该接口的对象。（若Lambda 表达式抛出一个受检异常，那么该异常需要在目标接口的抽象方法上进行声明）。
+ 可以在任意函数式接口上使用@FunctionalInterface注解，这样做可以检查它是否是一个函数式接口，同时javadoc也会包含一条声明，说明这个接口是一个函数式接口。

---

## 流(Stream)
是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列。
"集合讲的是数据，流讲的是计算！"

注意：
+ Stream 自己不会存储元素。
+ Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
+ Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。

Stream 的操作三个步骤
+ 创建Stream
    + 一个数据源（如：集合、数组），获取一个流
+ 中间操作
    + 一个中间操作链，对数据源的数据进行处理
+ 终止操作(终端操作)
    + 一个终止操作，执行中间操作链，并产生结果