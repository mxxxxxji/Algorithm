import java.util.*
import java.io.*
import kotlin.collections.ArrayList

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val n = Integer.parseInt(readLine())
    val e = Integer.parseInt(readLine())
    val graph = Array(n+1){ arrayListOf<Int>() }
    val visited = BooleanArray(n+1){false}
    var st : StringTokenizer
    repeat(e){
        st = StringTokenizer(readLine())
        val row = Integer.parseInt(st.nextToken())
        val col = Integer.parseInt(st.nextToken())
        graph[row].add(col)
        graph[col].add(row)
    }

    print(dfs(1, graph, visited)-1)
}
fun bfs(){
    var q : Queue<Int> = LinkedList()
    q.offer(1)
    while(!q.isEmpty()){
        val p = q.poll()
       // for(i in 0 until )
    }
}
private fun dfs(com:Int, graph:Array<ArrayList<Int>>, visited:BooleanArray):Int{
    visited[com] = true
    var count = 1
    for(i in 0 until graph[com].size){
        val next = graph[com][i]
        if(visited[next]) continue

        count += dfs(next, graph, visited)

    }
    return count
}