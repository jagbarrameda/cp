import java.util.Arrays.sort

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var n = readln().toInt()
        var a = readln().split(' ').map { it.toInt() }.toIntArray()
        sort(a)
        var rem = 1
        var ansd = false
        for (i in n - 1 downTo 0) {
            val v = a[i]
            var j = i - 1
            while (j >= 0 && a[j] == v) j--
            val c = i - j
            if (c % 2 == rem) {
                ansd = true
                println("YES")
                break
            }
            rem = (rem + 1) % 2
        }
        if (!ansd)
            println(if (rem % 2 == 0) "YES" else "NO")
    }
}