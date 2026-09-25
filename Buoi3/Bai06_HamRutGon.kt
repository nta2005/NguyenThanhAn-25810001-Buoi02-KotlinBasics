// Nguyen Thanh An - 2581001

fun binhPhuongDayDu(x: Int): Int {
    return x * x
}
fun binhPhuongRutGon(x: Int): Int = x * x

fun chuViHinhVuongDayDu(canh: Double): Double {
    return canh * 4
}
fun chuViHinhVuongRutGon(canh: Double): Double = canh * 4

fun laSoChanDayDu(x: Int): Boolean {
    return x % 2 == 0
}
fun laSoChanRutGon(x: Int): Boolean = x % 2 == 0

fun main() {
    println("Binh phuong: ${binhPhuongDayDu(5)} - ${binhPhuongRutGon(5)}")
    println("Chu vi hinh vuong: ${chuViHinhVuongDayDu(4.0)} - ${chuViHinhVuongRutGon(4.0)}")
    println("La so chan: ${laSoChanDayDu(7)} - ${laSoChanRutGon(7)}")
}
