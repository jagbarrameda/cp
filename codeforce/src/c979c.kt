// could not solve it
// learning: look for and find the trick.
// The trick involved looking at ways to win for alice.
// I tried to find all the combinations, screwed.
fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val a = readln()
        var ans = false
        if (a[0] == '1' || a[n - 1] == '1') ans = true
        else {
            for (i in 1 until n) {
                if (a[i] == '1' && a[i - 1] == '1') {
                    ans = true
                    break
                }
            }
        }
        println(if (ans) "YES" else "NO")
    }
}