import kotlin.math.cbrt

fun main() {
    // Завдання 5.1 див. у файлі "Завдання 5.1.png"

    // Завдання 5.2
    println("Сума елементів масиву a, значення яких кратні N, введіть N: ")
    val N = readln().toInt()
    println("Сума елементів масиву a, які кратні $N: ${var2z2(N)}")

    // Завдання 5.3
    println("Протабулювати функцію")
    println("Start X: ")
    val start = readln().toDouble()
    println("End X: ")
    val end = readln().toDouble()
    println("Step: ")
    val step = readln().toDouble()

    var2z3(start, end, step)
}


// Сума елементів масиву a, значення яких кратні N.
fun var2z2(N: Int) : Int {
    val n = 2
    val size = 50
    val p = IntArray(size)
    val a = IntArray(size)

    p[0] = n
    for (i in 1 until size) {
        p[i] = (p[i - 1] * 67 + 11) % 128
    }

    for (i in p.indices) {
        a[i] = p[i] - 64
    }

    val sumElements = a.filter { it % N == 0 }.sum()

    return sumElements
}


// Табулювання функції y = cbrt(x)
fun var2z3(startX: Double, endX: Double, step: Double) {
    val xValues = mutableListOf<Double>()
    val yValues = mutableListOf<Double>()

    var x = startX
    while (x <= endX) {
        val y = cbrt(x)

        xValues.add(x)
        yValues.add(y)
        x += step
    }

    val yMin = yValues.minOrNull()
    val yMax = yValues.maxOrNull()
    val xMin = xValues[yValues.indexOf(yMin)]
    val xMax = xValues[yValues.indexOf(yMax)]

    println("yMin = $yMin при x = $xMin")
    println("yMax = $yMax при x = $xMax")

    val sumY = yValues.sum()
    val averageY = yValues.average()

    println("Сума елементів масиву y: $sumY")
    println("Середнє арифметичне значення елементів масиву y: $averageY")
}