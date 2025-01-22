import java.util.Collections.sort

fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (n,m) = readln().split(" ").map { it.toInt() }
        val cards = mutableListOf<List<Int>>()
        val firstCards = mutableListOf<List<Int>>()
        for (i in 0 until n) {
            val cow=readln().split(" ").map { it.toInt() }
            sort(cow)
            cards.add(cow)
            firstCards.add(listOf(cow[0], i))
        }
        var good= true
        val p = mutableListOf<Int>()
        for (card in 0 until n) {
            for (i in 0 until n) {
                if (firstCards[i][0]==card) {
                    if (p.contains(i)) {
                        good= false
                    }
                    p.add(i)
                    break
                }
                if (!good) break
            }
            if (!good) break
        }
        if (!good) {
            println(-1)
            continue
        }
        var card = n
        for (round in 1 until m) {
            for (i in 0 until n) {
                val cow = p[i]
                if (cards[cow][round] != card) {
                    good = false
                    break
                }
                card++
            }
            if (!good) break
        }
        if (!good) {
            println(-1)
            continue
        }
        println(p.map { it -> it + 1}.toList().joinToString(" "))
    }
}
