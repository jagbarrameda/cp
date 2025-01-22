fun main() {
    for (i in 0..10) {
        println(i)
        println(Integer.toBinaryString(i))
        println(Integer.toBinaryString(-i))
        println(Integer.toBinaryString(i - (-i and i)))
        println()
    }
}


