import java.util.*


fun main() {
    var tt = readln().toInt()
    while (tt-- > 0) {
        val (n, m, L) = readln().split(" ").map { it.toInt() }
        val h = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
        val p = Array(m) { readln().split(" ").map { it.toInt() }.toIntArray() }

        val bestP = PriorityQueue<Int> { x, y -> y - x }

        var i = 0
        var j = 0
        var e = 1
        var ans = 0
        while (i < h.size) {
            var pos = h[i][0]
            while (j < p.size && p[j][0] <= pos) {
                bestP.add(p[j][1])
                j++
            }
            val reqEnergy = 1 + h[i][1] - h[i][0] + 1
            while (e < reqEnergy && bestP.isNotEmpty()) {
                e += bestP.remove()
                ans++
            }
            if (e >= reqEnergy) {
                i++
            } else {
                // not enough energy
                ans = -1
                break
            }
        }
        println(ans)
    }
}

