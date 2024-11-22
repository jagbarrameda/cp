import java.util.*
import java.util.Arrays.sort

fun main() {
    var tt = readln().toInt()
    while (tt-- > 0) {
        val k = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }.toIntArray()
        sort(a)
        val total = k - 2
        var n = 1

        while (n * n < total) {
            while (total % n != 0 && n * n < total)
                n++
            val m = total / n
            // if a contains n and m
            val nPos = Arrays.binarySearch(a, n)
            val mPos = Arrays.binarySearch(a, m)
            if (nPos < 0 || mPos < 0) {
                n++
                continue
            }
            if (n != m) {
                break
            }
            // n == m
            if ((nPos > 0 && a[nPos-1] == n)
                || (nPos < k - 1 && a[nPos+1] == n)) {
                break
            }
            n++
        }
        println("$n ${total / n}")
    }
}
