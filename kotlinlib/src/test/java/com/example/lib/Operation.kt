package com.example.lib

import org.junit.jupiter.api.Assertions
import java.io.File
import java.lang.Integer.parseInt
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import org.junit.jupiter.api.Test


/**
 * 空安全
 * 可空类型与非空类型
 * https://www.kotlincn.net/docs/reference/null-safety.html#%E5%9C%A8%E6%9D%A1%E4%BB%B6%E4%B8%AD%E6%A3%80%E6%B5%8B-null
 */
class Operation {

    /**
     * try 是一个表达式，即它可以有一个返回值：
     * try-表达式的返回值是 try 块中的最后一个表达式或者是（所有）catch 块中的最后一个表达式。
     * finally 块中的内容不会影响表达式的结果。
     */
    @Test
    fun test00() {
        val result: Int? = try {
            parseInt("xx")
        } catch (e: NumberFormatException) {
            null
        }
        println(result)
        Assertions.assertNull(result)
    }

    @Test
    fun test0() {
        val simpleName = MutableList::class.java.canonicalName;
        val simpleName2 = List::class.java.canonicalName;
        val simpleName3 = java.util.List::class.java.canonicalName
        println(simpleName)
        println(simpleName2)
        println(simpleName3)

        val eq =
            MutableList::class.java == java.util.List::class.java && MutableList::class.java === java.util.List::class.java
        val eq2 =
            ArrayList::class.java == java.util.ArrayList::class.java && ArrayList::class.java === java.util.ArrayList::class.java
        Assertions.assertTrue(eq)
        Assertions.assertTrue(eq2)
    }

    /**
     * https://stackoverflow.com/questions/41888269/intclass-javaprimitivetype-kotlin-reference-not-equal-to-intclass-javaobject
     */
    @Test
    fun test1() {
        val result =
            Int::class.javaPrimitiveType!!.kotlin == Int::class.javaObjectType.kotlin // true

        val result2 =
            Int::class.javaPrimitiveType!!.kotlin === Int::class.javaObjectType.kotlin // false
        println(result)
        println(result2)
    }

    /**
     * 当我们调用 vararg-函数时，我们可以一个接一个地传参，
     * 例如 asList(1, 2, 3)，
     * 或者，如果我们已经有一个数组并希望将其内容传给该函数，
     * 我们使用伸展（spread）操作符（在数组前面加 *）：
     */
    @Test
    fun test2() {
        val a = arrayOf(1, 2, 3)
        val list = listOf(-1, 0, *a, 4)
        println(list)
    }

    /**
     * 可变数量的参数（Varargs）
     * 函数的参数（通常是最后一个）可以用 vararg 修饰符标记：
     */
    private fun <T> asList(vararg ts: T): List<T> {
        val result = ArrayList<T>()
        for (t in ts) // ts is an Array
            result.add(t)
        return result
    }

    /**
     * 在函数内部，类型 T 的 vararg 参数的可见方式是作为 T 数组，
     * 即上例中的 ts 变量具有类型 Array <out T>。
     * 只有一个参数可以标注为 vararg。
     * 如果 vararg 参数不是列表中的最后一个参数，
     * 可以使用具名参数语法传递其后的参数的值，
     * 或者，如果参数具有函数类型，则通过在括号外部传一个 lambda。
     */
    @Test
    fun test4() {
        //允许将可变数量的参数传递给函数：
        val list = asList(1, 2, 3)
        println(list)
    }


    @Test
    fun test() {
        val name = "R\$drawable"
        println(name)
    }

    /**
     * 在条件中检测 null
     */
    @Test
    fun testNull() {
        val b: String? = "123456"
        if (b != null && b.isNotEmpty()) {
            print("String of length ${b.length}")
        } else {
            print("Empty string")
        }
    }


    /**
     * ?. (安全调用操作符)
     * val b: String? = null
     * val result = b?.length
     * 如果 b 非空，就返回 b.length，否则返回 null
     */
    @Test
    fun testSafeOperation() {
        val b: String? = null
        val result = b?.length
        println("b?.length = $result")
        Assertions.assertNull(result)

        val a: String? = "12345"
        val length = a?.length
        println("a?.length = $length")
        Assertions.assertEquals(5, length)
    }

    /**
     * 安全调用在链式调用中很有用。
     */
    @Test
    fun testSafeOperation2() {
        // 例如，如果一个员工 Bob 可能会（或者不会）分配给一个部门，
        // 并且可能有另外一个员工是该部门的负责人，那么获取 Bob 所在部门负责人（如果有的话）的名字，我们写作：
        // bob?.department?.head?.name
        // 如果任意一个属性（环节）为空，这个链式调用就会返回 null。
        println("bob?.department?.head?.name 如果任意一个属性（环节）为空，这个链式调用就会返回 null")
    }

    /**
     * 如果要只对非空值执行某个操作，安全调用操作符可以与 let 一起使用：
     * 安全调用也可以出现在赋值的左侧。
     * 这样，如果调用链中的任何一个接收者为空都会跳过赋值，而右侧的表达式根本不会求值：
     */
    @Test
    fun testSafeOperation3() {
        val listWithNulls: List<String?> = listOf("Kotlin", null)
        for (item in listWithNulls) {
            item?.let { println(it) } // 输出 Kotlin 并忽略 null
        }
    }

    /**
     * ?:
     * Elvis 操作符
     * 如果 ?: 左侧表达式非空，elvis 操作符就返回其左侧表达式，否则返回右侧表达式。
     * 请注意，当且仅当左侧为空时，才会对右侧表达式求值。
     */
    @Test
    fun testElvisOperation() {
        val result = testElvis(null)
        val result2 = testElvis("12345")
        Assertions.assertEquals(-1, result)
        Assertions.assertEquals(5, result2)
    }

    /**
     * Elvis 操作符
     */
    private fun testElvis(b: String?): Int {
        //当我们有一个可空的引用 b 时，我们可以说"如果 b 非空，我使用它；否则使用某个非空的值"：
        //val l: Int = if (b != null) b.length else -1

        // 除了完整的 if-表达式，这还可以通过 Elvis 操作符表达，写作 ?:
        // 如果 ?: 左侧表达式非空，elvis 操作符就返回其左侧表达式，否则返回右侧表达式。
        // 请注意，当且仅当左侧为空时，才会对右侧表达式求值。
        return b?.length ?: -1;
    }


    @Test
    fun testElvisOperation2() {
        val result = elvisHandleException("12345")
        println(result)
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            elvisHandleException(null)
        }
    }

    /**
     * 请注意，因为 throw 和 return 在 Kotlin 中都是表达式，
     * 所以它们也可以用在 elvis 操作符右侧。
     * 这可能会非常方便，例如，检测函数参数：
     */
    private fun elvisHandleException(name: String?): String {
        val length = name?.length ?: throw IllegalArgumentException("name is null")
        return "$name length: $length"
    }

    /**
     * !! (非空断言运算符)
     * 第三种选择是为 NPE 爱好者准备的：非空断言运算符（!!）将任何值转换为非空类型，
     * 若该值为空则抛出异常。
     * 我们可以写 b!! ，这会返回一个非空的 b 值 （例如：在我们例子中的 String）或者如果 b 为空，就会抛出一个 NPE 异常：
     * 因此，如果你想要一个 NPE，你可以得到它，但是你必须显式要求它，否则它不会不期而至
     */
    @Test
    fun testOperation() {
        val b: String? = null
        Assertions.assertThrows(NullPointerException::class.java) {
            val l = b!!.length
        }
    }

    /**
     * 安全的类型转换
     * Type conversion
     *
     * 如果对象不是目标类型，那么常规类型转换可能会导致 ClassCastException。
     * 另一个选择是使用安全的类型转换，如果尝试转换不成功则返回 null：
     */
    @Test
    fun testSafeTypeConversion() {
        val a = null
        val result: Int? = a as? Int
        println("result = $result")
        Assertions.assertNull(result)
    }

    @Test
    fun testSafeTypeConversion2() {
        val a = 100
        val result: Int? = a as? Int
        println("result = $result")
        Assertions.assertEquals(100, result)
    }

    /**
     * 可空类型的集合
     * 如果你有一个可空类型元素的集合，并且想要过滤非空元素，
     * 你可以使用 filterNotNull 来实现：
     */
    @Test
    fun testNullList() {
        val nullableList: List<Int?> = listOf(1, 2, null, 4)
        val intList: List<Int> = nullableList.filterNotNull()
        for (num in intList) {
            println(num)
        }
    }


    /**
     * 一个解构声明同时创建多个变量，并且可以单独使用这些变量。
     * 对于每一个解构的变量，
     * 在访问时，实际最终都会调用解构对象的componentN()方法，
     * 而N就是声明时括号里变量的位置，从1开始。
     */
    //Deconstruction
    @Test
    fun testDeconstruction() {
        val p = Point(10, 20)
        val (x, y) = p
        print(x)    //10
        print(y)    //20
    }

    /**
     * 解构
     * https://www.jianshu.com/p/e943c7b2bfce
     */
    @Test
    fun testDeconstruction1() {
        val list = listOf(
            Point(10, 20),
            Point(30, 40),
            Point(50, 60)
        )
        for ((a, b) in list) {
            println(a * b)        //200，1200，3000
        }
    }

    @Test
    fun testDeconstruction2() {
        // 现在，使用该函数：
        val (result, status) = function()
        println(result)
        println(status)
    }

    private fun function(): Result {
        // 各种计算
        return Result(200, "success")
    }

    @Test
    fun testDeconstruction3() {
        testPair()
    }

    private fun testPair() {
        val (a, b) = getPair()
        println(a)
        println(b)
        val (x, y, z) = getTriple()
        println(x)
        println(y)
        println(z)
    }

    private fun getPair(): Pair<String, Int> {
        return Pair("hhh", 666)
    }

    private fun getTriple(): Triple<String, Int, Float> {
        return Triple("hhh", 233, 2.33f)
    }

    /**
     * lay
     * by lazy只能作用于val关键字标注的属性。
     * 当属性用到的时候才会初始化"lazy{}"里面的内容
     * 而且再次调用属性的时候，只会得到结果，而不会再次执行lazy{}的运行过程
     */
    @Test
    fun layFunctionTest() {
        val lazyValue: String by lazy {
            println("computed!")
            println("computed!")
            println("computed!")
            println("computed!")
            println("computed!")
            "Hello"
        }
        println(lazyValue)
        println(lazyValue)
    }

    /**
     * apply
     *
     * 有了apply函数，你就不用显式地在menuFile变量上调用每个属性设置函数了，
     * 因为都在lambda表达式里隐式调用了。
     *
     * 这里apply函数施展的黑魔法就是通过带接收者的函数字面量实现的。
     * 再仔细看一下apply的定义，注意看叫block的函数参数是如何定义的：
     * private inline fun <T> T.apply(block: T.() -> Unit): T {
     *      block()
     *      return this
     * }
     *
     *
     * block函数参数不仅是个lambda表达式，它还是个泛型类型的扩展T: T.() -> Unit。
     * 这就是你定义的lambda表达式能隐式访问接收者实例的属性和函数的奥秘。
     *
     * 通过定义为一个扩展，lambda表达式的接收者同时也是apply函数的接收者实例
     * ——允许在lambda表达式里访问接收者实例的函数和属性。
     *
     * 使用这样的编程范式，就可以写出业界知名的"领域特定语言"（DSL）——一种API编程范式，
     * 暴露接收者的函数和特性，以便于使用你定义的lambda表达式来读取和配置它们。
     */
    @Test
    fun applyFunctionTest() {
        val menuFile = File("../app/.gitignore").apply {
            setReadable(true)
            setWritable(true)
            setExecutable(false)
        }.readText().split("\n")

        println(menuFile)
    }

    @Test
    fun test222() {
        val nullList: List<Any>? = null
        val b1 = nullList.isNullOrEmpty() // true
        println(b1)

        val empty: List<Any> = emptyList()
        val b2 = empty.isNullOrEmpty() // true
        println(b2)

        val collection: List<Char> = listOf('a', 'b', 'c')
        val b3 = collection.isNullOrEmpty() // false
        println(b3)
    }


    /**
     * Contract 契约 极简教程
     * https://www.jianshu.com/p/a35f99adf365
     */
    fun f0(s: String?): Int {
        return if (s != null) {
            s.length
        } else 0
    }
    //compile error
    //private fun f1(s: String?): Int {
    //    return if (isNotEmpty(s)) {
    //     s.length
    //     } else 0
    // }

    private fun f1(s: String?): Int {
        return if (isNotEmpty(s)) {
            s?.length ?: 0
        } else 0
    }

    private fun isNotEmpty(s: String?): Boolean {
        return s != null && s != ""
    }

    //由于Contract契约API还是Experimental，所以需要使用ExperimentalContracts注解声明
    @ExperimentalContracts
    private fun isNotEmptyWithContract(s: String?): Boolean {
        // val a = 1
        // 这里契约的意思是: 调用 isNotEmptyWithContract 函数，会产生这样的效果:
        // 如果返回值是true, 那就意味着 s != null.
        // 把这个契约行为告知到给编译器，编译器就知道了下次碰到这种情形，你的 s 就是非空的，自然就smart cast了。
        contract {
            returns(true) implies (s != null)
        }
        return s != null && s != ""
    }

    @ExperimentalContracts
    private fun getLengthWithContract(s: String?): Int {
        return if (isNotEmptyWithContract(s)) {
            s.length
        } else 0
    }

    @Test
    @ExperimentalContracts
    fun contractTest() {
        val length = getLengthWithContract("abc")
        val length2 = getLengthWithContract("123")
        Assertions.assertEquals(3, length)
        Assertions.assertEquals(3, length2)
    }

    /**
     * closeable use
     *
     * 实现了Closeable接口的对象可调用use函数
     * use函数会自动关闭调用者（无论中间是否出现异常）
     * Kotlin的File对象和IO流操作变得行云流水
     * https://blog.csdn.net/qq_33215972/article/details/79762878
     */
    @Test
    fun closeableUseTest() {
        File("../app/.gitignore")
            .readLines()
            .forEach { println(it) }
    }

    /**
     * also函数
     * also函数和let函数功能相似。
     * 和let一样，also也是把接收者作为值参传给lambda。
     * 但有一点不同：also返回接收者对象，而let返回lambda结果。
     *
     * 因为这个差异，also尤其适合针对同一原始对象，利用副作用做事。
     * 例如，在下面这个例子里，also被调用了两次，
     * 每次做一件事：打印文件名一次，把文件内容赋值给fileContents变量一次。
     * 既然also返回的是接收者对象，你就可以基于原始接收者对象执行额外的链式调用。
     */
    @Test
    fun alsoTest() {
        var fileContents: List<String>
        val file = File("../app/.gitignore")
            .also {
                println("alsoFunction:" + it.name)
            }.also {
                fileContents = it.readLines()
            }
        println("alsoFunction:$file")
        println("alsoFunction:$fileContents")
    }

}