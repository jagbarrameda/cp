
fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = IntArray(n)
        println(a)
    }
}

class C983d {
    fun query(a: Int, b: Int): Int {
        println("? $a $b")
        return readln().toInt()
    }

    fun println(a: IntArray) {
        println("! ${a.joinToString(" ")}")
    }
}