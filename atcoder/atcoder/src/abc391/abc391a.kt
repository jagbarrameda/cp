fun main() {
    val d = readln()
    val ans = when (d) {
        "S"-> "N"
        "N" -> "S"
        "E" -> "W"
        "W" -> "E"
        "NE" -> "SW"
        "SW" -> "NE"
        "NW" -> "SE"
        "SE" -> "NW"
        else -> ""
    }
    println(ans)
}