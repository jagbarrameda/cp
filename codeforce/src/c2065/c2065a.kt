fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val noun = readln()
        println(noun.substring(0, noun.length-2) + "i")
    }
}
