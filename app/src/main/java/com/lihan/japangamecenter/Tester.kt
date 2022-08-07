package com.lihan.japangamecenter

fun calculate(
    x : Int ,
    y : Int ,
    operation : (Int, Int)->Int) : Int {

    return operation(x,y)
}
//(Int, Int)->Int
fun sum(x : Int , y :Int) = x + y


fun main() {
    println("Hi")

    val sumResult =
        calculate(
            4,
            5
        ) { a, b ->
            a * b
        }
    println(sumResult)
}



