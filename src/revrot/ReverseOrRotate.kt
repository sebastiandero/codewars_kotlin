package revrot

import kotlin.test.assertEquals

fun revRot(nums: String, sz: Int): String {
    val chunks: MutableList<String> = mutableListOf()
    var last = 0

    if (sz <= 0 || sz > nums.length || nums.trim().isEmpty()) return ""

    while (nums.length > last && last + sz < nums.length) {
        chunks.add(nums.substring(last, last + sz))
        last += sz
    }
    return chunks.joinToString(separator = "") { s -> reverseOrRotate(s) }
}

fun reverseOrRotate(chunk: String): String {
    val digits: List<Int> = chunk.split("").filter { s -> !s.isEmpty() }.map { s -> s.toInt() }

    val sumOfSquares = digits.map { i -> Math.pow(i.toDouble(), 2.0) }.sum()

    return if (sumOfSquares % 2 == 0.0) {
        chunk.reversed()
    } else {
        chunk.substring(1, chunk.length) + chunk.substring(0, 1)
    }
}

private fun testing(actual: String, expected: String) {
    assertEquals(expected, actual)
}

fun main(args: Array<String>) {
    println("Fixed Tests: revRot")
    var s = "733049910872815764"
    testing(revRot(s, 5), "330479108928157")
    s = "73304991087281576455176044327690580265896"
    testing(revRot(s, 8), "1994033775182780067155464327690480265895")
    s = "73304991087281576455176044327690580265896896028"
    testing(revRot(s, 8), "1994033775182780067155464327690480265895")
}