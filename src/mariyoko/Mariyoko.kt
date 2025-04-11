package mariyoko

import java.io.File

class Mariyoko {
    fun run(filename: String) {
        // TODO: actually implement Mariyoko
        File(filename).forEachLine {
            println(it)
        }
    }
}