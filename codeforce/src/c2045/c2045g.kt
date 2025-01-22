//import java.lang.Math.pow
//import java.util.PriorityQueue
//import kotlin.math.pow
//
//fun main() {
//    val (R, C, X) = readln().split(' ').map { it.toInt() }
//    val g = Array(R) { readln() }
//    val d = listOf(-1, 0, 1, 0, -1)
//    val minC = Array(R * C) { LongArray(R * C) { Long.MAX_VALUE } }
//    for (i in 0 until R * C) minC[i][i] = 0
//
//    val visited = BooleanArray(R * C) { false }
//    val q = PriorityQueue<List<Long>> { x, y -> (x[0] - y[0]).toInt() }
//    q.add(listOf(0L, 0L))
//
//    while (q.isNotEmpty()) {
//        val e = q.poll()
//        val r = e[1].toInt() / C
//        val c = e[1].toInt() % C
//
//        for (i in 0..3) {
//            val nr = r + d[i]
//            val nc = c + d[i + 1]
//            val neigidx = nr*C + nc
//            if (!visited[neigidx]) {
//                minC[e[1].toInt()][neigidx] = (g[r][c] - g[nr][nc]).toDouble().pow(X.toDouble()).toLong()
//                visited[neigidx] = true
//                q.add(
//                    listOf(
//                        minC[e[1]][neigidx],
//                        neigidx)
//                )
//            }
//            if (!(nr in 0..<R && nc in 0..<C)) continue
//            val idxi = r * C + c
//            val idxj = nr * C + nc
//            minC[idxi][idxj] =
//        }
//    }
//    for ()
//}
