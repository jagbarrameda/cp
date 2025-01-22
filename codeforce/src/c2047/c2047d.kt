import java.util.Arrays.sort
import kotlin.math.min

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }.toIntArray()
        val changed = BooleanArray(n)
        var min = a[n - 1]
        var minChanged = Int.MAX_VALUE
        for (i in n - 1 downTo 0) {
            if (a[i] > min) {
                a[i]++
                changed[i] = true
                minChanged = min(minChanged, a[i])
                continue
            }
            min = min(min, a[i])
        }
        for (i in n - 1 downTo 0) {
            if (!changed[i] && a[i] > minChanged) {
                a[i]++
            }
        }
        sort(a)
        println(a.joinToString(" "))
    }
}

/*
3
3
2 1 3
5
1 2 2 1 4
6
1 2 3 6 5 4

 */

