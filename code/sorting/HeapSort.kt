package sort

class HeapSort {
    fun heapSort(arr: IntArray) {
        buildHeap(arr)
        println(arr.joinToString())
        for (i in arr.lastIndex downTo 1) {
            swap(arr, 0, i)
            heapify(arr, 0, i)
            println(arr.joinToString())
        }
    }

    fun buildHeap(arr: IntArray) {
        for (i in arr.indices.reversed()) {
            heapify(arr, i, arr.size)
        }
    }

    fun heapify(arr: IntArray, index: Int, heapSize: Int) {
        var largest = index
        val left = 2 * index + 1
        val right = 2 * index + 2

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left
        }

        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right
        }

        if (largest != index) {
            swap(arr, index, largest)
            heapify(arr, largest, heapSize)
        }
    }

    fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}
