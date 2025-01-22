import java.util.*

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val a = PriorityQueue<Int>(n, Collections.reverseOrder())
        a.addAll(readln().split(" ").map { it.toInt() })
        val b = PriorityQueue<Int>(m, Collections.reverseOrder())
        b.addAll(readln().split(" ").map { it.toInt() })

        while (a.size > 0 && b.size > 0) {
            if (a.peek() == b.peek()) {
                a.poll()
                b.poll()
                continue
            }
            if (a.peek() > b.peek() || b.size == 0) break
            val d = b.poll()
            if (d > 1L * a.peek() * a.size) {
                break
            }
            if (d%2 == 1) {
                b.add(d/2)
                b.add(d/2 + 1)
            } else {
                b.add(d/2)
                b.add(d/2)
            }
        }
        println(if (a.size== 0 && b.size == 0) "Yes" else "No")
    }
}

/*
4
3 2
1 2 3
2 4
3 2
1 2 3
1 5
3 2
1 2 3
3 3
3 3
1 2 3
1 2 3

1
10 2
1 1 1 1 1 1 1 1 1 1
4 6

3
4 1
1 1 1 1
4
4 1
1 1 1 1
1 3
4 1
1 1 1 1
2 2

 */