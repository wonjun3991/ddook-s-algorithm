package sort

open class Sort {
    fun bubbleSort(array: IntArray): IntArray {
        for (i in 0 until array.size - 1) {
            for (j in 0 until array.size - 1 - i) {
                if (array[j] > array[j + 1]) {
                    println(array.joinToString())
                    swap(array, j, j + 1)
                }
            }
        }
        return array
    }

    fun selectionSort(array: IntArray): IntArray {
        for (i in 0 until array.size - 1) {
            var minIndex = i
            for (j in i + 1 until array.size) {
                if (array[j] < array[minIndex]) {
                    minIndex = j
                }
            }
            swap(array, i, minIndex)
            println(array.joinToString())
        }

        return array
    }

    fun insertionSort(array: IntArray): IntArray{
        for(i in 1 until array.size){
            val key = array[i]
            var j = i - 1

            while(j >= 0 && array[j] > key){
                array[j+1] = array[j]
                j = j - 1
            }
            array[j + 1] = key
            println(array.joinToString())
        }
        return array
    }

    private fun swap(array: IntArray, a: Int, b: Int) {
        val temp = array[a]
        array[a] = array[b]
        array[b] = temp
    }
}
