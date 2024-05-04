# Sorting

### Bubble sort

![Untitled](Sorting/Untitled.png)

```kotlin
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
```

### Selection Sort

![Untitled](Sorting/Untitled%201.png)

```kotlin
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
```

### Insertion Sort

![Untitled](Sorting/Untitled%202.png)

```kotlin
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
```

## Merge Sort

- divide and conquer 방식을 통해 정렬
    - 다이나믹 프로그래밍

| LEFT |  |  |  |
| --- | --- | --- | --- |
| 27 | 38 |  |  |
|  |  |  |  |
| RIGHT  |  |  |  |
| 10 | 43 |  |  |
|  | ㅇ |  |  |
| MERGED |  |  |  |
| 10 | 27 | 38 | 43 |
|  |  |  |  |

![Untitled](Sorting/Untitled%203.png)

```kotlin
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
```

## Quick Sort

- pivot을 기준으로 좌우를 나눔

![Untitled](Sorting/Untitled%204.png)

1 3 2 4 5 6 8 7/  9 /  

## Heap Sort

- heapify
    - heap을 만들어가는 과정
    - 하나의 리스트가 들어왔을 때 이진힙을 만들어주는지 검증

1,2,3,4,5

      2  

  3    4

5

→ priority queue(우선순위 큐) 가중치가 제일 높은 데이터를 제일먼저 나오게 하는 자료구조

|  | heap | array |
| --- | --- | --- |
| 삽입 | log n | 1 |
| 삭제 | log n  | 1 |
| 조회 | 1 | n |

| 0 | 1 | 2 | 3 | 4 |  |
| --- | --- | --- | --- | --- | --- |
| 10  | 5 | 4 | 3 | 1  | build heap |
| 1 | 5 | 4 | 3 | 10 | swap |
| 5 | 4 | 3 | 1 | 10 | heapify |
| 1 | 4 | 3 | 5 | 10 | swap |
| 4 | 3 | 1 | 5 | 10 | heapify |
| 3 | 1 | 4 | 5 | 10 | swap |

## Shell Sort

- shell 이란 사람이 발견
- 삽입 정렬을 마지막에
    - 삽입 정렬의 최대 시간복잡도를 그대로 가져감
- 평균적인 시간 복잡도가 삽입 정렬에 비해 빠름
- Gap Sequence
    - gap 을 이용하여 정렬을 하는데 마지막에 삽입 정렬을 사용

## Tim Sort

- [https://d2.naver.com/helloworld/0315536](https://d2.naver.com/helloworld/0315536)
- merge sort와 insertion sort를 같이 사용
    - insertion sort의 경우 참조 지역성이 좋다
    - merge sort의 경우 공간을 크게 사용하게 되는데 이를 해결할 수 있다.
- Run
    - 2^x 개씩 잘라 각각을 Insertion sort로 정렬하되, 이후는 Insertion sort를 진행하지 않고 덩어리를 최대한 크게 만들어 병합 횟수를 최대한 줄이는 것이다.

| 0 | 1 | 2 | 3 | 4 | 5 |
| --- | --- | --- | --- | --- | --- |
| 1 | 2 | 3 | 4 | 5 | 6 |

![Untitled](Sorting/Untitled%205.png)
