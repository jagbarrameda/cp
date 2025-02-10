fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toLong() }
    var ans = true
    for (i in 1 until a.size - 1) {
        ans = (a[1] * a[i]) == (a[0] * a[i + 1])
        if (!ans) break
    }
    print(if (ans) "Yes" else "No")
}