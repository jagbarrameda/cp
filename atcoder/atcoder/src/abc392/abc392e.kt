import java.util.PriorityQueue

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val dsu = Abc392e.DSU(n)
    val degs = IntArray(n)
    for (i in 0 until m) {
        val (s1, s2) = readln().split(" ").map { it.toInt() }
        dsu.j(s1-1, s2-1)
        degs[s1-1]++
        degs[s2-1]++
    }
    val ccs = mutableSetOf<Int>()
    val map = mutableMapOf<Int, PriorityQueue<Int>> ()
    for (i in 0 until n) {
        ccs.add(dsu.p(i))
        if (!map.containsKey(dsu.p(i))) {
            map[dsu.p(i)] = PriorityQueue()
        }
        map[dsu.p(i)]?.add(degs[i])
    }
    println(ccs.size - 1)

    if (ccs.size == 1) return

    val ops = mutableListOf<Pair<Int,Int>>()

    for (i in 0 until ops.size) {
        println("$i ${ops[i].first} ${ops[i].second}")
    }
}

object Abc392e {
    class DSU(n: Int) {
        val p = IntArray(n)
        val s = IntArray(n)

        init {
            for (i in 0 until n) {
                p[i] = i
                s[i] = 1
            }
        }

        fun p(i: Int): Int {
            if (p[i] != i) {
                p[i] = p(p[i])
                s[p[i]] += s[i]
            }
            return p[i]
        }

        fun j(i: Int, j: Int): Int {
            val pi = p(i)
            val pj = p(j)
            if (pi != pj) {
                p[pi] = pj
                s[pj] += s[pi]
            }
            return pj
        }
    }
}