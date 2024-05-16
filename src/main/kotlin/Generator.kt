import com.google.gson.Gson
import dto.Folder
import java.io.File

class Generator {
    fun generate(filename: String, count: Int) {
        val gson = Gson()
        val entities = mutableListOf<Folder>()

        repeat(count) {
            entities.add(Folder("Folder${it + 1}"))
        }

        val json = gson.toJson(entities)
        File(filename).writeText(json)

        println("Generated $count entities and saved to $filename")
    }
}