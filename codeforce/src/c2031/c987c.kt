fun main() {
    var t = readln().toInt()
    while (t-- > 0) {
        val n = readln().toInt()
        var ans : IntArray
        if (n % 2 == 1) {
            // maybe
            if (n < 27)
                ans = intArrayOf(-1)
            else {
                ans = IntArray(n)
                ans[0] = 1
                for (i in 1 until 9 step 2) {
                    ans[i] = i+1
                    ans[i+1] = i+1
                }
                ans[9] = 1
                for (i in 10 until 22 step 2) {
                    ans[i] = i+1
                    ans[i+1] = i+1
                }
                ans[22] = 3
                ans[23] = 24
                ans[24] = 24
                ans[25] = 1
                ans[26] = 3
                for (i in 27 until n step 2) {
                    ans[i] = i+1
                    ans[i+1] = i+1
                }
            }
        }
        else {
            // all good
            ans = IntArray(n)
            var i = 0
            while (i < n - 1) {
                ans[i] = i + 1
                ans[i+1] = i + 1
                i+=2
            }
        }
        println(ans.joinToString(" "))
    }
}

/*
4
5
1 2 3 4 5
5
1 3 2 5 4
1
1
5
2 1 4 5 3
 */