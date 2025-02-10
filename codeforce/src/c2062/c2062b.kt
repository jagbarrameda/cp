fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }
        var ans = true
        // going right
        for (i in a.indices) {
            val ldist = 2*i
            val rdist = 2*(n-1-i)
            if (ldist >= a[i]) ans=false
            if (rdist >= a[i]) ans=false
            if (!ans) break
        }
        println(if (ans) "Yes" else "No")
    }
}
