package sort

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class SortTest {
    var array = intArrayOf(7, 4, 5, 1, 3)
    var expectedArray = intArrayOf(1, 3, 4, 5, 7)

    @Test
    fun bubbleSort() {
        val solution = Sort()

        assertContentEquals(expectedArray, solution.bubbleSort(array))
    }


    @Test
    fun selectionSort() {
        val solution = Sort()

        assertContentEquals(expectedArray, solution.selectionSort(array))
    }

    @Test
    fun insertionSort() {
        val solution = Sort()

        assertContentEquals(expectedArray, solution.insertionSort(array))
    }

    @Test
    fun mergeSort() {
        val solution = MergeSort()
        assertContentEquals(expectedArray, solution.mergeSort(array))
    }

    @Test
    fun heapSort(){
        val arr = intArrayOf(20, 15, 81, 12, 6)
        val hs = HeapSort()
        hs.heapSort(arr)

        assertContentEquals(intArrayOf(6,12,15,20,81), arr)
    }
}
