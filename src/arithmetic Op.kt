import com.sun.jdi.Value
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

    val fn2 = ::power
    println(fn2(2,10))
    
    val fn3 : (Int,Int) -> Int = { a, b -> a.toDouble().pow(b).toInt() }  //lamda Function
    println(fn3(2,3))

    arrayPractice()

    var Vivek = Person("vivek",23,false)
    Vivek.getInfo()

    var Meti = Teacher("meti",45,true,"computer Networking")
    Meti.getInfo1()

    var car1=Car("rolls royce",300.0)
    car1.getInfoCar()

    var mob = Mobile()
    println(mob.toString())

    val circle1 : Circle =Circle(7.0)  //early binding as type inference is already of child class
    val rectangle1: Rectangle=Rectangle(3.0, 4.0)    //early binding as type inference is already of child class
    println(circle1.area())
    println(rectangle1.area())

    val circle2 : Shape = Circle(9.0)    //Late binding as reference is given of parent class,in runtime it will decide to choose which child
    val shapes : Array<Shape> = arrayOf(Circle(3.0),Rectangle(5.0,7.0),circle2,circle1)//type inference of Array is Shape so Late Binding
    areaOfShapes(shapes)

    val games : Array<Game> = arrayOf(Kabaddi(),KhoKho())
    gamesInfo(games)

    val objects: Array<Drawable> = arrayOf(Painting("monalisa"),Painting("Picasso"),Drawer())
    allDrawableObj(objects)

    var objA =A()
    var objB =B()
    println(objB.print())

    var generic= generic1<Int>(5)
    generic.SetValue(10)
    println(generic.GetValue())

    var varArg = generalAddition<Long>(3000000,700000)
    println(varArg.Calculation())
    println(varArg.Vararguments(1,2,3,4,5,6,7,8,9,10))

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
    while(i < 3){
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
} //Lamda Function Example Go to Main
//---------------------------------------------------------------------
fun power(a: Int=2, b: Int=2): Int {
    return a.toDouble().pow(b).toInt()
} //Lamda Function Example Go to Main
//---------------------------------------------------------------------
fun arrayPractice(){
    var arr:Array<Int> = arrayOf(1,2,3,4)
    var arr2:Array<String> = arrayOf("hi","hello","good","morning")
    var arr3 = IntArray(3)

//    for (i in 0..arr3.size-1){
//        arr3[i]= readLine()!!.toInt()
//    }
//    for(num in arr3){
//        println(num)
//    }
//    for((i,e) in arr2.withIndex()){
//        println("$i -> $e")
//    }

    println(arr.get(2))
    arr.set(2,10)
    println(arr[2])
}
//---------------------------------------------------------------------

//---------------------------------------------------------------------Object Oriented Programming {Inheritance}

open class Person(val name:String,private val age:Int){
    protected var maleOrNot=false
    constructor(name : String,age : Int, maleOrNot : Boolean): this(name,age){
        this.maleOrNot=maleOrNot
    }
    init {
        println("$name is Created")
    }
    fun getInfo(){
        val result = if(maleOrNot) "male" else "female"
        println("$name -> $age and $result")
    }
}
class Teacher(name:String,age:Int ,maleOrNot:Boolean,val sub : String) : Person(name,age,maleOrNot) {

    fun getInfo1() {
        println("$name  -> $maleOrNot -> $sub")

    }
}

//---------------------------------------------------------------------Getters and Setters and Lateinit

class Car(name: String, speed: Double) {
    var name: String = name
        set(value) {
            field = if (value.lowercase() == "bmw") value.lowercase() else "bmw"
        }

    var speed: Double = speed
        set(value) {
            if (value < 0) {
                println("Speed cannot be a negative value")
            } else {
                field = value
            }
        }

    lateinit var colour: String

    fun getInfoCar() {
        colour = if (name.lowercase() == "bmw") "white" else "black"
        println("Car is $name with max speed $speed and color $colour")
    }
}

//-------------------------------------------------------------------- ANY CLASS METHODS

class Mobile (){
    override fun toString(): String {
        return super.toString()
    }
}

//-------------------------------------------------------------------- Polymorphism (Early and Late Binding)

open class Shape {
    open fun area(): Double{
        return 0.0
    }
}

class Circle(val rad:Double) : Shape(){
    override fun area(): Double{
        return Math.PI * rad * rad
    }
}

class Rectangle(val l:Double,val b:Double) : Shape(){
    override fun area(): Double{
        return l * b
    }
}

fun areaOfShapes(shapes : Array<Shape>) {
    for(shape : Shape in shapes){
        println(shape.area())
    }
}

//------------------------------------------------------------------- Abstract class and methods

abstract class Game{
    abstract val name : String
    abstract fun rules() : String
}   //properties and methods is not defined properly but done in child class i.e, Abstract class

class Kabaddi : Game(){
    override val name = "kabaddi"

    override fun rules(): String {
        val rule :String = "max players in court 6"
        return rule
    }
}

class KhoKho : Game(){
    override val name = "khoKho"
    override fun rules(): String {
        val rule :String = "max players in court 9"
        return rule
    }
}

fun gamesInfo(games : Array<Game>){
    for (game : Game in games){
        println(game.rules())
    }
}

//------------------------------------------------------------------ Interface

interface Drawable{
    fun draw()
}

class Painting(val name : String) : Drawable {
    override fun draw(){
        println("$name is Drawable")
    }
}

class Drawer() : Drawable {
    override fun draw() {
        println("Drawer is drawable")
    }
}

fun allDrawableObj(objects : Array<Drawable>){
    for(obj : Drawable in objects){
        println(obj.draw())
    }
}

//--------------------------------------------------------------- Visibility Modifiers

 open class A{
     public var p = 10
     internal var q = 20
     private var r = 30
     protected var s = 40
 }

class B : A(){
     fun print(){
        println("$p $q $s")
    }
}    //except for r everything is accesible

//--------------------------------------------------------------- Vararg and generic classes

class generic1<T>(var data : T){
    fun SetValue(value : T){
        data = value
    }

    fun GetValue(): T{
        return data
    }
} //Generic

class generalAddition<T : Number>(val a: T, val b: T) {

    fun Calculation() : Double {
        return a.toDouble() + b.toDouble()
    }

    fun Vararguments(vararg  numbers: Int) : Int {
        var sum = 0
        for(num in numbers){
            sum += num
        }
        return sum
    }
} //generic with Restriction and var arguments

