fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, m1, m2) = readln().split(" ").map { it.toInt() }
        val e1 = Array(m1) { readln().split(" ").map { it.toInt() } }
        val e2 = Array(m2) { readln().split(" ").map { it.toInt() } }
        val g = C2060.DSU(n)
        for (e in e2) g.j(e[0] - 1, e[1] - 1)
//        println(e1.joinToString(" "))
//        println(e2.joinToString(" "))

        var ans = 0
        val f = C2060.DSU(n)
        for (e in e1) {
            val i = e[0] - 1
            val j = e[1] - 1
            if (g.p(i) != g.p(j)) {
                ans++
            } else {
                f.j(i, j)
            }
        }
//        for (i in 0 until n -1) {
//            val j = i + 1
//            if (g.p(i) != g.p(j)) continue
//            if (f.p(i) != f.p(j)) {
//                f.j(i, j)
//                ans++
//            }
//        }

        val s1 = HashSet<Int>()
        for (i in 0 until n) s1.add(g.p(i))
        val s2 = HashSet<Int>()
        for (i in 0 until n) s2.add(f.p(i))
        ans += (s2.size - s1.size)

//        for (i in 0 until n) print("${g.p(i) + 1} ")
        println(ans)
    }
}

object C2060 {
    class DSU(n: Int) {
        val p = IntArray(n)

        init {
            for (i in 0 until n) p[i] = i
        }

        fun p(i: Int): Int {
            if (p[i] != i) p[i] = p(p[i])
            return p[i]
        }

        fun j(i: Int, j: Int): Int {
            val pi = p(i)
            val pj = p(j)
            if (pi != pj) p[pi] = pj
            return pj
        }
    }
}

/*

1
4 2 3
1 2
1 3
1 2
1 3
2 3

 */

/*
1
20 19 22
20 11
18 10
5 1
8 1
6 7
7 13
12 1
14 4
1 6
16 5
1 11
1 4
3 1
7 19
7 17
4 15
8 10
5 9
1 2
6 17
14 4
14 6
7 1
8 10
1 2
4 7
10 13
5 13
15 9
2 16
18 4
12 2
9 14
5 15
5 4
14 15
8 13
2 3
7 13
1 17
18 11

 */