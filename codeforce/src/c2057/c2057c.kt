fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val (l, r) = readln().split(" ").map { it.toInt() }
        println(c2057c.f(l, r).joinToString(" "))
    }
}

object c2057c {
    fun f(l: Int, r: Int): List<Int> {
        val len = 31 - r.countLeadingZeroBits()
        val a = r // a > b > c
        val b = r - 1
        var c = 0
        var mask = 1 shl len
        while ((l and mask) == (r and mask)) {
            c = c or (r and mask)
            mask = mask shr 1
        }
        // start of differences
        var cGood = false
        while (mask > 0) {
            if ((a and mask) != (b and mask)) {
                if (mask < l || c or mask < b) {
                    // we must or can use 1
                    c = c or mask
                    cGood = cGood || (l and mask == 0)
                } else {
                    // we leave c[i]=0
                }
            } else {
                // a[i]==b[i]
                if (a and mask == 0) {
                    // c[i] = 1 is best
                    c = c or mask
                    cGood = cGood || (l and mask == 0)
                } else {
                    // a[i]==b[i]==1
                    if (cGood || (l and mask) == 0) {
                        // we can use c[i]=0
                    } else {
                        // only 1 is an option
                        c = c or mask
                    }
                }
            }
            mask = mask shr 1
        }

        return listOf(a, b, c)
    }

}