/**
 * P12-Highly divisible triangular number
 * The sequence of triangle numbers is generated by adding the natural numbers.
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28.
 * The first ten terms would be:
 *          1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * Let us list the factors of the first seven triangle numbers:
 *
 *   1: 1
 *   3: 1,3
 *   6: 1,2,3,6
 *  10: 1,2,5,10
 *  15: 1,3,5,15
 *  21: 1,3,7,21
 *  28: 1,2,4,7,14,28
 *
 *  We can see that 28 is the first triangle number to have over five divisors.
 *  What is the value of the first triangle number to have over five hundred divisors?
 */
fun p12() {
    var n = 0L
    var triangular = 0L
    var limit: Long
    var power: Int
    var factors = 1
    while (factors < 500) {
        n++
        triangular = (n * (n + 1)) / 2
        power = 0
        factors = 1
        limit = triangular
        for (i in 2..limit) {
            if (limit % i == 0L) {
                do {
                    power++
                    limit /= i
                } while (limit % i == 0L && limit != 1L)
            }
            factors *= (power + 1)
            power = 0
        }
    }
    println("A12: $triangular")
}