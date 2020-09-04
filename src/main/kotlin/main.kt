import kotlin.math.sqrt

fun main(args: Array<String>) {
    q1()
    q2()
    q3()
    q4()
}

/**
 * Q1 - Multiple of 3 and 5
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
fun q1(limit: Int = 1000) {
    var sum = 0
    for (i in 1 until limit) {
        if (i % 3 == 0 || i % 5 == 0) sum += i
    }
    println("A1: $sum")
}

/**
 * Q2 - Even Fibonacci numbers
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 * By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 */
fun q2(limit: Int = 4_000_000) {
    var f0 = 1
    var f1 = 2
    var f2: Int
    var sum = f1
    while (f0 + f1 < limit) {
        f2 = f0 + f1
        if (f2 % 2 == 0) sum += f2
        f0 = f1
        f1 = f2
    }
    println("A2: $sum")
}

/**
 * Q3-Largest prime factor
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
fun q3(num: Long = 600_851_475_143L) {
    var isPrime = true
    val primeFactors = mutableListOf<Long>()
    for (i in 2..sqrt(num.toDouble()).toInt()) {
        if ((num % i) == 0L) {
            for (j in primeFactors) {
                if (i % j == 0L) isPrime = false
            }
            if (isPrime) primeFactors.add(i.toLong())
            isPrime = true
        }
    }
    println("A3: ${primeFactors.last()}")
}

/**
 * Q4-Largest palindrome product
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

fun q4() {
    var product: Int
    var sup = 0
    var lb: Int; var ub: Int
    for (f1 in 999 downTo 99) {
        f2@for (f2 in 999 downTo 99) {
            product = f1 * f2
            ub = product.toString().length - 1
            lb = 0
            while (ub > lb) {
                if (product.toString()[lb] == product.toString()[ub]) {
                    ub--
                    lb++
                } else continue@f2
            }
            sup = if(product > sup) product else sup
        }
    }
    println("Supremum: $sup")
}