fun main(args: Array<String>) {
    val generator = Generator()
    val filename = args[1]
    val count = args[2].toInt()
    generator.generate(filename, count)

    val folders = FolderParser.getFoldersFromFile(filename)
    println(folders.toString())
}