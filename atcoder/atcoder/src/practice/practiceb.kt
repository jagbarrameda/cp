fun main() {
    val (n,q) = readln().split(" ").map { it.toInt() }

    var query = fun (c1:Int, c2:Int):Int {
        println("? ${c1} ${c2}")
        return if (readln().equals("<")) -1 else 1
    }

    var qq=q
    while (qq-->0){
        var qans=query(1,2)
        println(qans)
    }
    val ans = mutableListOf<Int>()
    ans.sort()
    println("! ${ans}")
}

/*
2 2
<
>

 */