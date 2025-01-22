fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        var odd = 0
        readln().split(" ").map { it.toInt() }.forEach{ odd += (it and 1) }
        var ans = 0
        if (n!=odd) {
            ans = odd + 1
        }
        else {
            ans = odd - 1
        }

        println(ans)
    }
}
