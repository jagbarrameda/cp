fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val c = readln().split(" ").map(String::toInt)
        val max = c.max()
        val cnt = IntArray(max+1)

        for (i in c) {
            cnt[i] ++
        }
        var ans = cnt.count { it == 1 }
//        var rem = ans % 2 // 0 => alice starts taking when there are no 1-marble colors, 1 => bob
        ans = ((ans + 1) / 2) * 2 // alice's score from 1-marble colors
        ans += cnt.count { it > 1 } // alice's score from 2+ -marble colors

        println(ans)
    }
}
