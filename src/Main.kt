//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val arr = arrayOf("hi","hello","hii")
    val key = "hi"
    val arr2 =  FilteredArrayOfString(arr,key)
    for (word in arr2) {
        println(word)
    }
}

fun FilteredArrayOfString(arr : Array<String>,key : String) : MutableList<String?> {
    val len = key.length
    var arr2 : MutableList<String?> = mutableListOf<String?>()
    for(word in arr){
//        if(word.substring(0, len) != key ){
//            arr2.add(word)
//        }
        if(!word.contains(key))
            arr2.add(word)
    }
    return arr2
}