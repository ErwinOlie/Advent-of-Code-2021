val input = object {}.javaClass.getResource("input.txt")!!.readText()

var submarine1 = Position(0, 0)
var submarine2 = Position(0, 0)
var aim2 = 0

fun main() {
    input.lines()
        .forEach {
            val direction = it.split(' ')[0]
            val units = it.split(' ')[1].toInt()
            when (direction) {
                "forward" -> submarine1 = submarine1.forward(units)
                "down" -> submarine1 = submarine1.down(units)
                "up" -> submarine1 = submarine1.down(-units)
            }
        }

    println(submarine1.x * submarine1.depth)

    input.lines()
        .forEach {
            val direction = it.split(' ')[0]
            val units = it.split(' ')[1].toInt()
            when (direction) {
                "down" -> aim2 += units
                "up" -> aim2 -= units
                "forward" -> submarine2 = submarine2.forward(units).down(aim2 * units)
            }
        }

    println(submarine2.x * submarine2.depth)
}

data class Position(val x: Int, val depth: Int) {
    fun forward(units: Int) = Position(x + units, depth)
    fun down(units: Int) = Position(x, depth + units)
}
