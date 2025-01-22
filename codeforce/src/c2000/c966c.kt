fun main() {
    val maxInt = 1000000001
    var t = readln().toInt()
    while (t-- > 0) {
        var n = readln().toInt()
        var a = readln().split(" ").map { it.toInt() }
        val firstCharIdx = mutableMapOf<Int, Int>()
        for (i in a.indices) {
            if (!firstCharIdx.containsKey(a[i])) {
                firstCharIdx[a[i]] = i
            }
        }
        var m = readln().toInt()
        while (m-- > 0) {
            val s = readln()
            var matches = true
            if (s.length != a.size) {
                matches = false
            } else {
                val map = IntArray(26) { maxInt }
                for (i in a.indices) {
                    val ch = s[i] - 'a'
                    if (map[ch] == maxInt) {
                        map[ch] = a[i]
                    }
                    if (map[ch] != a[i]) {
                        matches = false
                        break
                    }
                    val firstCh = s[firstCharIdx[map[ch]]!!]
                    if (firstCh != s[i]) {
                        matches = false
                        break
                    }
                }
            }
            println(if (matches) "YES" else "NO")
        }
    }
}
/*
18
2
5 1
5
dd
mm
ru
fianf
qt
1
3
5
f
zz
s
m
vivq
2
2 4
1
ah
5
1 5 1 2 5
1
gjjgi
5
4 4 3 4 2
1
inixr
4
2 4 5 3
1
zkpf
5
2 2 3 5 1
4
reeav
susli
ngggf
nlnzz
2
5 2
4
um
fa
jy
sp
5
1 4 3 4 4
3
rnnrn
iiigi
ffror
5
1 5 1 2 4
1
rqqaq
2
5 4
2
px
dg
2
5 2
4
tr
iz
ut
ys
2
1 3
2
mr
md
3
3 3 5
3
mq
tti
yor
4
4 2 1 2
2
oamd
kwrr
3
4 2 4
2
zjz
ddy
5
1 5 3 1 1
3
fffyy
jjxrr
dpddd
5
5 5 1 4 1
3
eeoeo
qwqff
ppffc

 */