class Solution {
    lateinit var checkedLand: Array<IntArray>
    lateinit var globalLand: Array<IntArray>
    lateinit var start: Pair<Int, Int>
    lateinit var end: Pair<Int, Int>
    val farmLands: MutableList<IntArray> = mutableListOf()
    val directions =  arrayOf(0 to 1, 1 to 0)

    fun findFarmland(land: Array<IntArray>): Array<IntArray> {
        checkedLand = Array(land.size) { IntArray(land.first().size) {0} }
        globalLand = land

        for(h in land.indices){
            for(w in land[h].indices){
                if(land[h][w]  == 1 && checkedLand[h][w] != 1){
                    start = h to w
                    dfs(h to w)
                    farmLands.add(intArrayOf(start.first, start.second, end.first, end.second))
                }
            }
        }
        return farmLands.toTypedArray()
    }

    fun dfs(land: Pair<Int, Int>){
        if(checkedLand[land.first][land.second] == 1 || globalLand[land.first][land.second] != 1){
            return
        }

        checkedLand[land.first][land.second] = 1
        if(checkLast(land)){
            end = land
        }

        directions.forEach{
            val height = land.first + it.first
            val weight = land.second + it.second

            if(height >= checkedLand.size || height < 0){
                return@forEach
            }
            if(weight >= checkedLand.first().size || weight < 0){
                return@forEach
            }

            dfs(height to weight)
        }
    }

    fun checkLast(land: Pair<Int, Int>):Boolean{
        directions.forEach{
            val height = land.first + it.first
            val weight = land.second + it.second

            if(height >= checkedLand.size && weight >= checkedLand.first().size){
                return true
            }

            if(height >= checkedLand.size){
                return@forEach
            }
            if(weight >= checkedLand.first().size){
                return@forEach
            }

            if(globalLand[height][weight] == 1){
                return false
            }
        }
        return true
    }
}
