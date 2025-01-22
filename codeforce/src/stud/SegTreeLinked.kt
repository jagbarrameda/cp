package stud

class SegTreeLinked<S, T>(
    val l: Int,
    val r: Int,
    a: List<S>,
    private val op: (T, T) -> T,
    private val e: (S) -> T
){
    var v: T
    val lChild: SegTreeLinked<S, T>?
    val rChild: SegTreeLinked<S, T>?

    init {
        if (l == r) {
            v = e(a[l])
            lChild = null
            rChild = null
        } else {
            val mid = l + (r - l) / 2
            lChild = SegTreeLinked(l, mid, a, op, e)
            rChild = SegTreeLinked(mid + 1, r, a, op, e)
            v = op(lChild.v, rChild.v)
        }
    }

    fun query(l: Int, r: Int): T {
        if (this.l == l && this.r == r) {
            return this.v
        }
        if (r <= lChild!!.r) return lChild.query(l, r)
        if (l >= rChild!!.l) return rChild.query(l, r)
        return this.op(
            lChild.query(l, lChild.r),
            rChild.query(rChild.l, r)
        )
    }

    fun update(i: Int, value: S) {
        if (l == r && i == l) {
            this.v = e(value)
            return
        }
        val mid = l + (r - l) / 2
        if (i <= mid) {
            lChild!!.update(i, value)
        } else {
            rChild!!.update(i, value)
        }
        this.v = op(lChild!!.v, rChild!!.v)
    }
}