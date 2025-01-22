import java.util.*


fun main() {
    val (n, a, b) = readln().split(' ').map { it.toInt() }
    val p = PriorityQueue<LongArray> { x, y -> (x[0] - y[0]).toInt() }
    val aGdc = getGcdArray(a)
    val bGdc = getGcdArray(b)
    p.add(longArrayOf(2, 1, 1))
    while (p.isNotEmpty()) {
        // o(n^2)
        val (c, i, j) = p.poll()
        if (i.toInt() == n && j.toInt() == n) {
            println(c)
            return
        }
        if (i < n) {
            // go down
            val ni = ((i + 1) % a).toInt()
            val nj = (j % b).toInt()
            p.add(longArrayOf(c + aGdc[ni] + bGdc[nj], i + 1, j))
        }
        if (j < n) {
            // go down
            val ni = ((i) % a).toInt()
            val nj = ((j + 1) % b).toInt()
            p.add(longArrayOf(c + aGdc[ni] + bGdc[nj], i, j + 1))
        }
    }
}

fun getGcdArray(a: Int): IntArray {
    // gdc for all numbers from 0 to a inclusive
    val gdc = IntArray(a + 1) { 1 }
    gdc[a] = a
    gdc[0] = a // by my weird convention to make gcd(a,k*a) = a
    gdc[1] = 1
    for (i in 2 until a) {
        if (a % i != 0) continue
        for (j in i until a step i) {
            gdc[j] = i
        }
    }
    return gdc
}

//fun gcd(a: Int, b: Int): Int {
//    if (b == 0) return a
//    return gcd(b, a % b)
//}