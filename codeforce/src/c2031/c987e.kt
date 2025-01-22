import kotlin.math.floor
import kotlin.math.max
import kotlin.math.sqrt

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        val tree = readln().split(" ").map { it.toInt() - 1 }.toMutableList()
        tree.add(0, -1)

        val deg = getDegs(tree)

        var ans = -1
        for (i in 0 until n) {
            val d = getDepth(tree, i)
            val k = deg[i]
            ans = max(ans, (d + floor(sqrt(k + 1.0)) - 1).toInt())
        }
        println(ans)
    }
}

fun getDegs(tree: List<Int>): IntArray {
    val deg = IntArray(tree.size)
    for (parent in tree) {
        if (parent == -1) continue
        deg[parent]++
    }
    return deg
}

fun getDepth(tree: List<Int>, node: Int): Int {
    var ans = 0
    var curr = node
    while (tree[curr] != -1) {
        ans++
        curr = tree[curr]
    }
    return ans
}


/*
4
5
1 2 3 4 5
5
1 3 2 5 4
1
1
5
2 1 4 5 3

1
10
10 9 2 1 4 9 4 9 4 5

1
10
9 7 10 10 10 1 10 6 6 6

 */