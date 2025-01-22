package c2021

import java.util.Arrays.sort

fun main() {
    var t = readln().toInt()
    while (t-->0) {
        var n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }.toIntArray()
        sort(a)
        a.reverse()
        for (i in n - 2 downTo 0) {
            a[i] = (a[i] + a[i+1]) / 2
        }
        println(a[0])
    }
}