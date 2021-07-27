package com.malin.hook

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * 空安全
 * 可空类型与非空类型
 * https://www.kotlincn.net/docs/reference/null-safety.html#%E5%9C%A8%E6%9D%A1%E4%BB%B6%E4%B8%AD%E6%A3%80%E6%B5%8B-null
 */
class Operation {

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

    @Test
    fun test() {
        val name = ".R\$drawable"
        println(name)
    }

    /**
     * 在条件中检测 null
     */
    @Test
    fun testNull() {
        val b: String? = "Kotlin"
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
        println(result)
        Assertions.assertNull(result)

        val a: String? = "12345"
        val length = a?.length
        println(length)
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
        //当我们有一个可空的引用 b 时，我们可以说“如果 b 非空，我使用它；否则使用某个非空的值”：
        //val l: Int = if (b != null) b.length else -1

        // 除了完整的 if-表达式，这还可以通过 Elvis 操作符表达，写作 ?:
        // 如果 ?: 左侧表达式非空，elvis 操作符就返回其左侧表达式，否则返回右侧表达式。
        // 请注意，当且仅当左侧为空时，才会对右侧表达式求值。
        return b?.length ?: -1;
    }


    @Test
    fun testElvisOperation2() {
        val foo = foo("1")
        println(foo)
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            foo(null)
        }

    }

    /**
     * 请注意，因为 throw 和 return 在 Kotlin 中都是表达式，
     * 所以它们也可以用在 elvis 操作符右侧。
     * 这可能会非常方便，例如，检测函数参数：
     */
    private fun foo(name: String?): String {
        val length = name?.length ?: throw IllegalArgumentException("name is null")
        return name + length
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
        val l = b!!.length
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
        Assertions.assertNull(result)
    }

    @Test
    fun testSafeTypeConversion2() {
        val a = 100
        val result: Int? = a as? Int
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
}