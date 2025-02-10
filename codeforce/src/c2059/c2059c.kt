import java.io.PrintWriter
import java.util.stream.IntStream.range
import kotlin.math.min
import kotlin.streams.toList
import C2059c.io;

fun main() {
    var t = io.nextInt()
    while (t-- > 0) {
        val n = io.nextInt()
        val a = Array(n) { io.nextStrings().map { if (it == "1") 1 else 0 }.reversed() }

        if (n == 1) {
            println("1")
            continue
        }

        var candidates = range(0, n).toList().filter { a[it][0] == 1 }
        if (candidates.isEmpty()) {
            println("1")
            continue
        }

        var ans = 1  // last good
        for (j in 1 until n) {
            candidates = candidates.filter { a[it][j] == 1 }
            if (candidates.size < j) break
            ans++
        }
        io.println("${min(ans + 1, n)}")
    }
    io.done()
}

object C2059c {
    object io {
        val cin = System.`in`.bufferedReader()
        val cout = PrintWriter(System.out.bufferedWriter())
        val endl = "\n"
        val space = " "
        fun nextLine() = cin.readLine()!!.trim()
        fun nextInt() = nextLine().toInt()
        fun nextLong() = nextLine().toLong()
        fun nextStrings() = nextLine().split(space)
        fun nextInts() = nextStrings().map { it.toInt() }
        fun nextLongs() = nextStrings().map { it.toLong() }
        fun print(a: Int) = cout.write(a.toString() + space)
        fun print(s: String) = cout.write(s)
        fun println(s: String) = cout.write("$s$endl")
        fun flush() = cout.flush()
        fun done() = cout.flush()
    }
}

/*
9
1
1
1
2
1
3
2
1 1
1 1
2
1 1
1 2
2
1 2
2 1
2
10 10
10 10
3
2 3 3
4 4 1
2 1 1
4
4 2 2 17
1 9 3 1
5 5 5 11
1 2 1 1

 */