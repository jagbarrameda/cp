fun main() {
    var t = readln().toInt()
    while (t-- >0){
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }
        var ans = 1
        var layerSum = 0
        var layerSideLen = 2

        for (i in 1 until n) {
            layerSum += a[i]
            while (layerSum > 4 * layerSideLen) {
                layerSum -= 4 * layerSideLen
                layerSideLen += 2
            }
            if (layerSum < 4 * layerSideLen) {
                continue
            }
            if (layerSum == 4 * layerSideLen) {
                ans++
                layerSum = 0
                layerSideLen += 2
                continue
            }
        }
        println(ans)
    }
}
