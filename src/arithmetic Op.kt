import java.lang.classfile.constantpool.DoubleEntry
import kotlin.math.pow

fun main(args: Array<String>) {

    logicalAndShortCircuit()
    
    ifElseLadderWhen()
    println(inlineFunctionSum(2,5))
    
    defaultArgument()
    defaultArgument(10)
    
    println(namedArguments(b=7,a=8))
    
    println(funOverloading(22,22))
    println(funOverloading(22.2,22.2))

    var fn = :: variable
    println(fn(3,6))
    
    val fn2 = :: power
    println(fn2(2,10))
    
    val fn3 : (Int,Int) -> Int = { a, b -> a.toDouble().pow(b).toInt() }
    println(fn3(2,3))
}

//---------------------------------------------------------------------
fun logicalAndShortCircuit() {
    val above70 = true
    val androidDev = true

    var PlacementDrive = above70 && androidDev
    println(PlacementDrive)

}
//---------------------------------------------------------------------
fun ifElseLadderWhen(){
    val result = if(2>3)  "Good Morning" else "Good Afternoon"
    println(result)
    val animal = "pussy"
    when(animal){
        "pussy Cat" -> println("is a Cat")
        "Cat" -> println("is a pussy")
        "Dog" -> println("is a dog")
        else -> println("no animal found")
    }
}
//---------------------------------------------------------------------
fun whileDoWhile(){
    var i = 1
    var num = readLine()!!.toInt()
    while(i < 11){
        println("$num * $i = ${num * i}")
        i++
    }
}
//---------------------------------------------------------------------
fun inlineFunctionSum(num : Int, num2:Int) : Int = num+num2  //we can remove type also as we know it'll return int
//---------------------------------------------------------------------
fun defaultArgument(num : Int =2) {
    println(num)
}
//---------------------------------------------------------------------
fun namedArguments(a : Int, b: Int) = a+b
//---------------------------------------------------------------------
fun funOverloading(a:Int,b:Int) = a+b
//---------------------------------------------------------------------
fun funOverloading(a:Double,b:Double) = a+b
//---------------------------------------------------------------------
fun variable(a:Int,b:Int) : Int{
    return a+b
}
//---------------------------------------------------------------------
fun power(a: Int=2, b: Int=2): Int {
    return a.toDouble().pow(b).toInt()
}
//---------------------------------------------------------------------


