import java.util.*
import java.io.*

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())
    val N = Integer.parseInt(st.nextToken())
    val M = Integer.parseInt(st.nextToken())
    val R = Integer.parseInt(st.nextToken())

    var arr = Array(N){Array(M){0}}
    for(i in 0 until N){
        st = StringTokenizer(readLine())
        for(j in 0 until M){
            arr[i][j] = Integer.parseInt(st.nextToken())
        }
    }
    var cnt = Math.min(N, M)
    cnt /= 2
    for(r in 0 until R){
        var n = N;
        var m = M;
        for(c in 0 until cnt){
            var temp = arr[c][c]
            // <왼
            for(i in 1+c until m){
                arr[c][i-1] = arr[c][i]
            }
            // ^위
            for(i in 1+c until n){
                arr[i-1][m-1] = arr[i][m-1]
            }
            // >오
            for(i in m-1 downTo 1+c){
                arr[n-1][i] = arr[n-1][i-1]
            }

            // V아
            for(i in n-1 downTo 1+c){
                arr[i][c] = arr[i-1][c]
            }
            arr[c+1][c] = temp
            m--
            n--
        }

    }
    var sb = StringBuilder()
    for(i in 0 until N){
        for(j in 0 until M){
            sb.append(arr[i][j]).append(' ');
        }
        sb.append('\n')
    }

    print(sb)
}