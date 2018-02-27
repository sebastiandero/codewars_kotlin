package solution

fun twoOldestAges(ages: List<Int>): List<Int> = ages.sorted().takeLast(2)
