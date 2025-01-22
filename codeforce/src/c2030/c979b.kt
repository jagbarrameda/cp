// could not solve it
// learning: look for and find the trick. The trick involved math.
// I tried to get the math but I couldn't.
fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        // after lots of math we arrive to number of zeroes is n - 1 and 1 one
        if (n == 1) {
            println("0")
            continue
        }
        val sb = StringBuilder()
        for (i in 1 until  n) {
            sb.append('0')
        }
        if (n > 1) sb.append('1')
        println(sb.toString())
    }
}