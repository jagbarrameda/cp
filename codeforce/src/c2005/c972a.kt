fun main() {
    var t = readln().toInt()
    val l = listOf('a', 'e', 'i', 'o', 'u')
    while (t-- > 0) {
        val n = readln().toInt()
        val sb = StringBuilder()
        val rep = n / 5
        var rem = n % 5
        for (i in 0 until 5) {
            for (j in 0 until rep) {
                sb.append(l[i])
            }
            if (rem > 0) {
                sb.append(l[i])
                rem--
            }
        }
        println(sb.toString())
    }
}