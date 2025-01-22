fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        if (n == 1) {
            println(readln())
            continue
        }
        val s = readln().toCharArray()
        val cnt = IntArray(27)
        for (c in s) {
            cnt[c - 'a']++
        }
        var iMax = -1
        var iMin = -1
        for (i in 0 until 27) {
            if (cnt[i] == 0) continue
            if (iMax == -1 || cnt[i] > cnt[iMax]) iMax = i
            if (iMin == -1 || cnt[i] < cnt[iMin]) iMin = i
        }

        if (iMax == iMin) {
            // all same rep, any change will do
            val c = 'a' + iMax
            for (i in s.indices) {
                if (s[i] != c) {
                    s[i] = c
                    break
                }
            }
        } else {
            val cMin = 'a' + iMin
            val cMax = 'a' + iMax
            for (i in s.indices) {
                if (s[i] == cMin) {
                    s[i] = cMax
                    break
                }
            }
        }
        println(String(s))
    }
}
