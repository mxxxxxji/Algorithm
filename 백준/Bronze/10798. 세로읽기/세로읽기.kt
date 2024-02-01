import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var result = ""
    var word = Array(5){ CharArray(15){' '} }
    var maxSize = 0

    for(i in 0 until 5) {
        val str = readLine()
        maxSize = Math.max(str.length, maxSize)
        word[i] = str.toCharArray()
    }

    for(i in 0 until maxSize) {
        for(j in 0 until 5){
            if(word[j].getOrNull(i)==null) continue
            result += word[j][i]
        }
    }

    print(result)

}