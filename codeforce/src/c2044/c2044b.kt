fun main() {
    var t = readln().toInt()
    while (t-->0){
        var a = readln().toCharArray()
        for(i in a.indices){
            if (a[i] == 'p'){a[i]='q'
            continue}
            if (a[i]=='q'){a[i]='p'
            continue}
        }
        println(a.reversed().joinToString(""))
    }
}