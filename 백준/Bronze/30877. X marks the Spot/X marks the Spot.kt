import java.util.*
import java.io.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
        val N = Integer.parseInt(readLine())
        var st: StringTokenizer
        var answer :String = ""
        val sb = StringBuilder() 
        for(i in 0 until N){
                st = StringTokenizer(readLine())
                var s = st.nextToken()
                var t = st.nextToken()
                s = s.toUpperCase()
                t = t.toUpperCase()
                val p = s.indexOf('X')
                sb.append(t[p])
        }
        print(sb)
}