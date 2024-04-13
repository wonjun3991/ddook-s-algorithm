class Solution {
    fun tribonacci(n: Int, first: Int = 0, second: Int = 1, third: Int = 1): Int {
        if (n == 0) {
            return first
        }

        if (n == 1) {
            return second
        }

        if (n == 2) {
            return third
        }

        return tribonacci(n - 1, second, third, first + second + third)
    }
}
