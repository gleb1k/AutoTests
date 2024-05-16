import com.google.gson.Gson
import dto.Folder
import java.io.FileReader

object FolderParser {
    fun getFoldersFromFile(filename: String): List<Folder> {
        val gson = Gson()
        val reader = FileReader(filename)
        return gson.fromJson(reader, Array<Folder>::class.java).toList()
    }
}