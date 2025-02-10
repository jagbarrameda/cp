fun main() {
    val a = readln().split(" ").map { it.toInt() }
    var diff = -1
    for (i in a.indices) {
        if (a[i]==i+1) continue
        diff = i
        break
    }
    if (diff == -1 || diff + 1 >= 5 || a[diff]!=diff+2 || a[diff + 1] != diff + 1) {
        println("No")
        return
    }

    for (i in diff + 2 until a.size) {
        if (a[i]!=i+1) println("No")
    }
    println("Yes")
}