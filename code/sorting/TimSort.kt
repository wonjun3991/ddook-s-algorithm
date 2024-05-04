import kotlin.math.min

class TimSort {
    fun sort(array: Array<Int>) {
        val arraySize = array.size
        val minRunSize = minRunSize(arraySize)

        var i = 0
        while (i < arraySize) {
            insertionSort(array, i, min(i + minRunSize - 1, arraySize - 1))
            i += minRunSize
        }

        var mergingSize = minRunSize
        while (mergingSize < arraySize) {
            var start = 0
            while (start < arraySize) {
                val middle = start + mergingSize - 1
                val end = min(start + 2 * mergingSize - 1, arraySize - 1)
                if (middle < end) {
                    merge(array, start, middle, end)
                }
                start += mergingSize * 2
            }
            mergingSize *= 2
        }
    }

    private fun minRunSize(arraySize: Int) : Int {
        var result = 0
        var size = arraySize
        while (size >= 64) {
            result = result or (size and  1)
            size = size shr 1
        }

        return size + result
    }

    private fun insertionSort(array: Array<Int>, start: Int, end: Int) {
        var i = start + 1
        while (i <= end) {
            val current = array[i]
            var j = i - 1
            while (j >= start && array[j] > current) {
                array[j + 1] = array[j]
                j--
            }
            array[j + 1] = current
            i++
        }
    }

    private fun merge(array: Array<Int>, start: Int, middle: Int, end: Int) {
        val leftSize = middle - start + 1
        val rightSize = end - middle

        var i = 0
        val leftArray = Array(leftSize) { 0 }
        while (i < leftSize) {
            leftArray[i] = array[start + i]
            i++
        }

        i = 0
        val rightArray = Array(rightSize) { 0 }
        while (i < rightSize) {
            rightArray[i] = array[middle + i + 1]
            i++
        }

        i = 0
        var j = 0
        var k = start
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i]
                i++
            } else {
                array[k] = rightArray[j]
                j++
            }
            k++
        }

        while (i < leftSize) {
            array[k] = leftArray[i]
            i++
            k++
        }

        while (j < rightSize) {
            array[k] = rightArray[j]
            j++
            k++
        }
    }


}
