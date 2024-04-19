class Solution {
    private lateinit var checkGrid: Array<CharArray>
    private lateinit var globalGrid: Array<CharArray>
    private var area: Int = 0
    private val directions: List<Pair<Int, Int>> = listOf(-1 to 0, 0 to -1, 1 to 0, 0 to 1)

    fun numIslands(grid: Array<CharArray>): Int {
        checkGrid = Array(grid.size){ CharArray(grid.first().size) { '0' } }
        globalGrid = grid

        for (h in grid.indices){
            for(w in grid[h].indices){
                if(grid[h][w]  == '1' && checkGrid[h][w] != '1'){
                    dfs(h to w)
                    area += 1
                }
            }
        }

        return area
    }

    fun dfs(location: Pair<Int, Int>){
        if(checkGrid[location.first][location.second] == '1' || globalGrid[location.first][location.second] != '1'){
            return
        }

        checkGrid[location.first][location.second] = '1'

        directions.forEach{
            val height = location.first + it.first
            val weight = location.second + it.second

            if(height >= checkGrid.size || height < 0){
                return@forEach
            }
            if(weight >= checkGrid.first().size || weight < 0){
                return@forEach
            }

            dfs(height to weight)
        }
    }
}
