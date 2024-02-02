import java.util.*
import java.io.*
fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val N = Integer.parseInt(readLine())
    var arr = Array(100){Array(100){0}}
    var r : Int
    var c : Int
    var answer = 0
    for(num in 0 until N){
        val st = StringTokenizer(readLine())
        r = Integer.parseInt(st.nextToken())
        c = Integer.parseInt(st.nextToken())
        for(i in r until r+10){
            for(j in c until c+10){
                if(arr[i][j]==1) continue
                arr[i][j] = 1
                answer++;
            }
        }
    }
    print(answer)
}