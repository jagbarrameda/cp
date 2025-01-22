fun main() {

    var t = readln().toInt()
    while (t-- > 0) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val s = Array(n) { readln() }
        val ccs = Array(n) { IntArray(m) }
        val visited = Array(n) { BooleanArray(m) { false } }
        var ans = 0
        for (r in 0 until n) {
            for (c in 0 until m) {
                if (s[r][c] == '?') {
                    for (i in 0..3) {
                        val nr = r + d[i]
                        val nc = c + d[i + 1]
                        if (nr < 0 || nc < 0 || nr >= s.size || nc >= s[0].length) {
                            continue
                        }
                        if (s[nr][nc] == '?') {
                            ccs[r][c] = -1
                        } else {
                            updateCC(nr, nc, s, ccs, visited)
                            if (ccs[nr][nc] == -1) {
                                ccs[r][c] = -1
                                break
                            }
                        }
                    }
                } else {
                    updateCC(r, c, s, ccs, visited)
                }
                ans += if (ccs[r][c] == -1) 1 else 0
            }
        }
        println(ans)
    }
}

val d = listOf(-1, 0, 1, 0, -1)

fun updateCC(r: Int, c: Int, s: Array<String>, ccs: Array<IntArray>, visited: Array<BooleanArray>) {
    if (ccs[r][c] != 0) return

    if (s[r][c] == '?') return
    if (r == 0 && s[r][c] == 'U') ccs[r][c] = 1
    if (r == s.size - 1 && s[r][c] == 'D') ccs[r][c] = 1
    if (c == 0 && s[r][c] == 'L') ccs[r][c] = 1
    if (c == s[0].length - 1 && s[r][c] == 'R') ccs[r][c] = 1

    if (ccs[r][c] != 0) return

    val i = when (s[r][c]) {
        'L' -> 3
        'R' -> 1
        'D' -> 2
        'U' -> 0
        else -> -1 // cannot happen
    }
    val nr = r + d[i]
    val nc = c + d[i + 1]

    if (s[nr][nc] == '?' || visited[nr][nc]) {
        ccs[nr][nc] = -1
        ccs[r][c] = -1
    } else {
        visited[r][c] = true
        updateCC(nr, nc, s, ccs, visited)
        visited[r][c] = false
        ccs[r][c] = ccs[nr][nc]
    }
}
/*

11
3 3
?U?
L?R
?D?
3 3
?U?
L?D
?D?
3 3
?D?
L?R
?D?
3 3
?D?
L?R
?U?
3 3
???
???
???
3 3
???
DDD
DDD
3 3
???
DUD
D?D
4 5
??U??
?RUL?
??U??
??U??
7 6
??????
LLLLL?
????U?
?DL?U?
?D??U?
?RRRU?
??????
7 6
??????
LLLLL?
U???U?
?DL?U?
?D??U?
?RRRU?
??????
7 6
??????
LLLLL?
????U?
RDL?U?
?D?RU?
?RRRU?
??????


 */