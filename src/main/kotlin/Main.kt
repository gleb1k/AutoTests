fun main(args: Array<String>) {
    val generator = Generator()
    "generated"
    println("File name:")
    val filename = readln()
    println("Count:")
    val count = readln().toInt()
    generator.generate(filename, count)
}