package sort

open class MergeSort {
    fun merge(leftArray: IntArray, rightArray: IntArray): IntArray {
        val mergedArray = IntArray(leftArray.size + rightArray.size)
        var leftIndex = 0
        var rightIndex = 0
        var mergedIndex = 0

        while (leftIndex < leftArray.size && rightIndex < rightArray.size) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                mergedArray[mergedIndex] = leftArray[leftIndex]
                leftIndex++
            } else {
                mergedArray[mergedIndex] = rightArray[rightIndex]
                rightIndex++
            }
            mergedIndex++
        }

        while (leftIndex < leftArray.size) {
            mergedArray[mergedIndex] = leftArray[leftIndex]
            leftIndex++
            mergedIndex++
        }

        while (rightIndex < rightArray.size) {
            mergedArray[mergedIndex] = rightArray[rightIndex]
            rightIndex++
            mergedIndex++
        }

        return mergedArray
    }

    fun mergeSort(array: IntArray, startIndex: Int = 0, endIndex: Int = array.size-1): IntArray {
        if (array.size <= 1) {
            return array
        }

        val middleIndex = (startIndex + endIndex) / 2
        val leftArray = array.sliceArray(startIndex..middleIndex)
        val rightArray = array.sliceArray(middleIndex + 1..endIndex)

        return merge(mergeSort(leftArray), mergeSort(rightArray))
    }
}
