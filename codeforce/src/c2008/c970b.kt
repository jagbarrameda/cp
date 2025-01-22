import kotlin.math.sqrt

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val s = readln()
        val a = sqrt(n.toDouble()).toInt()
        if (a * a != n){
            println("NO")
            continue
        }
        var b = true
        var i = 0
        while (i < a && b) {
            b = b && (s[i] == '1')
            b = b && (s[n-1-i] == '1')
            i++
        }

        i = 1
        while (i < a - 1 && b) {
            b = b && (s[i * a] == '1')
            var j = 1
            while (j < a - 1 && b) {
                b = b && (s[i * a + j] == '0')
                j++
            }
            b = b && (s[(i + 1) * a - 1] == '1')
            i++
        }

        println(if (b) "YES" else "NO")
    }
}