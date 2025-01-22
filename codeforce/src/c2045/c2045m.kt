fun main() {
    val (R, C) = readln().split(" ").map { it.toInt() }
    val g = Array(R) { readln() }
    val mCnt = g.sumOf { it -> it.count { it != '.' } }
    val sides = listOf('W', 'E', 'S', 'N')
    var ans = ""
    var cnt = 0
    for (side in sides) {
        if (side in listOf('N', 'S')) {
            for (c in 0 until C) {
                val h = hits(g, side, c, R, C)
//                println("$side$c: $h hits")
                if (h == mCnt) {
                    ans += "$side${c + 1} "
                    cnt++
                }
            }
        } else {
            for (r in 0 until R) {
                val h = hits(g, side, r, R, C)
//                println("$side$r: $h hits")
                if (h == mCnt) {
                    ans += "$side${r + 1} "
                    cnt++
                }
            }
        }
    }

    println(cnt)
    if (cnt > 0)
        println(ans.substring(0, ans.length - 1))

}

val dd = listOf(-1, 0, 1, 0, -1)

fun hits(g: Array<String>, side: Char, rc: Int, R: Int, C: Int): Int {
    //val dd = listOf(-1, 0, 1, 0, -1)
    // aka: up, right, down, left
    var d = when (side) {
        'W' -> 1
        'E' -> 3
        'S' -> 0
        'N' -> 2
        else -> -1 // cannot happen
    }
    var r = when (side) {
        'W' -> rc
        'E' -> rc
        'S' -> R - 1
        'N' -> 0
        else -> -1 // cannot happen
    }
    var c = when (side) {
        'W' -> 0
        'E' -> C - 1
        'S' -> rc
        'N' -> rc
        else -> -1 // cannot happen
    }
    val hit = BooleanArray(R * C)
    while (r in 0..<R && c in 0..<C) {
        if (g[r][c] == '/') {
            hit[r * C + c] = true
            //val dd = listOf(-1, 0, 1, 0, -1)
            // aka: up, right, down, left
            d = when (d) {
                0 -> 1
                1 -> 0
                2 -> 3
                3 -> 2
                else -> -1 // cannot happen
            }
        }
        if (g[r][c] == '\\') {
            hit[r * C + c] = true
            //val dd = listOf(-1, 0, 1, 0, -1)
            // aka going: up, right, down, left
            d = when (d) {
                0 -> 3
                1 -> 2
                2 -> 1
                3 -> 0
                else -> -1 // cannot happen
            }
        }
        r += dd[d]
        c += dd[d + 1]
    }
    return hit.count { it }
}
