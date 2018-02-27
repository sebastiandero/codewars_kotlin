package solution

fun twoOldestAges(ages: List<Int>): List<Int> = ages.sortedDescending().subList(0, 2).sorted()
