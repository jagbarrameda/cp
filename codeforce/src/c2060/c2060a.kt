import kotlin.math.max

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val a = readln().split(" ").map { it.toInt() }
        var ans = 0
        val vals = listOf(a[0]+a[1], a[2]-a[1], a[2]+a[3])
        for (v in vals) {
            var cnt=0
            if (a[0]+a[1]==v) cnt++
            if (a[1]+v==a[2]) cnt++
            if (v+a[2]==a[3]) cnt++
            ans=max(ans,cnt)
        }
        println(ans)
    }
}
