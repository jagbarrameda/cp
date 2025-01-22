fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        var n = readln().toInt()
        var a = readln().split(" ").map { it.toInt() }
        var ans = IntArray(n)
        val MAX=200000
        var seen = BooleanArray(MAX+1)
        var next = 1
        for (i in a.indices) {
            if (!seen[a[i]]) {
                ans[i] = a[i]
                seen[a[i]] = true
            } else {
                while (seen[next]) next++
                ans[i] = next
                seen[next] = true
                next++
            }
        }
        println(ans.joinToString(" "))
    }
}