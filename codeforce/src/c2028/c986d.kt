@file:Suppress("DuplicatedCode")

import java.util.*

fun main() {
    // tle: test 10:
    // Input
    //100
    //2000
    var t = readln().toInt()
    val l = charArrayOf('Q', 'K', 'J')
    while (t-- > 0) {
        val n = readln().toInt()
        // def: cards: set [0,n-1]
        // def: players: set [0,2]
        // def: pa(p, a) = v \in [0,n-1], v pref of player p for card a, a \in cards, p \in players
        val pa = Array(3) { readln().split(" ").map { it.toInt() } }
//            println(pa.joinToString(" "))
        // def: reaches(n-1): set of cards that reach card n-1
        // def: dp[p][a] = b \in cards, b > a, b \in reaches(n-1)
        val dp = Array(3) { IntArray(n) { -1 } }
        for (p in 0 until 3) {
            dp[p][n - 1] = n - 1
        }
        // minCardToN[p][a]: minCardToN(a, p)=b, b \in cards, b \in reaches(n-1), b=min_{pref[p][bi]}(bi \in reaches(n-1))
        // at any card a, if pa[p][a] > pa[p][minToN[p]], we/ can trade 'a' for minToN[p] with player p
        val minCardToN =
            IntArray(3) { n - 1 } // we make [a] implicit as we only need the value for last [a] computed
        // dp[p][a] = b: b\in cards, b > a, dp[p][a] > dp[p][b]
        // this means that alice can trade card a, and gets card b from player p,
        // which is a path that leads to alice getting card n-1 eventually
        for (a in n - 2 downTo 0) {
            for (p in 0 until 3) {
                val b = minCardToN[p]
                if (pa[p][a] > pa[p][b]) {
                    // p prefers card a over b, and b in reaches(n-1), therefore a also reaches n-1
                    dp[p][a] = b
                    for (p2 in 0 until 3) {
                        // update minCardToN[p] for current [a] ([a] is implicit)
                        if (pa[p2][a] < pa[p2][minCardToN[p2]])
                            minCardToN[p2] = a
                    }
                    break
                }
            }
        }
        val ans = !(dp[0][0] == -1 &&
                dp[1][0] == -1 &&
                dp[2][0] == -1)
        val sb = StringBuilder()
        var cnt = 0
        if (ans) {
            var a = 0
            while (a != n - 1) {
                for (p in 0 until 3) {
                    if (dp[p][a] != -1) {
                        a = dp[p][a]
                        cnt++
                        sb.appendLine("${l[p]} ${a + 1}")
                        break
                    }
                }
            }
        }

        println(if (ans) "YES" else "NO")
        if (cnt != 0) {
            println(cnt)
            print(sb.toString())
        }
    }
}

/**
 * An edge from card a to card b traded with player p, and coming from Edge prev
 */
data class Edge(val a: Int, val b: Int, val p: Int, val prev: Edge? = null)

private class OtherAttempts {

    fun attempt2() {
        // tle: test 11:
        // Input
        //100
        //2000
        var t = readln().toInt()
        val l = charArrayOf('Q', 'K', 'J')
        while (t-- > 0) {
            val n = readln().toInt()
            val pa = Array(3) { readln().split(" ").map { it.toInt() } }
            val p = PriorityQueue<Edge> { e1, e2 -> e2.b - e1.b }

            // add edges from first card:
            for (b in 1 until n) {
                for (player in 0 until 3) {
                    if (pa[player][0] > pa[player][b]) {
                        val newEdge = Edge(
                            0, b, player, null
                        )
                        p.add(newEdge)
                        break
                    }
                }
            }

            var lastEdge: Edge? = null
            val visited = BitSet(n)
            visited[0] = true
            while (p.isNotEmpty() && visited.cardinality() != n) {
                val e = p.poll()
                if (visited[e.b]) continue
                visited[e.b] = true
                if (e.b == n - 1) {
                    lastEdge = e
                    break
                }
                // add to the queue, the edges starting from e.b
                for (b in e.b + 1 until n) {
                    for (player in 0 until 3) {
                        if (pa[player][e.b] > pa[player][b] && !visited[b]) {
                            val newEdge = Edge(
                                e.b, b, player, e
                            )
                            p.add(newEdge)
                            break
                        }
                    }
                }
            }

            println(if (lastEdge != null) "YES" else "NO")
            if (lastEdge != null) {
                var cnt = 0
                val sb = StringBuilder()
                var e = lastEdge
                while (e != null) {
                    sb.insert(0, "${l[e.p]} ${e.b + 1}\n")
                    e = e.prev
                    cnt++
                }
                println(cnt)
                print(sb.toString())
            }
        }
    }

}

/*
1
4
2 4 1 3
3 2 1 4
1 4 2 3

 */
/*
1
4
2 4 1 3
3 2 1 4
1 4 2 3

*/