// Nguyen Thanh An - 25810001

abstract class PhuongTienDiChuyen {
    abstract val tocDoToiDa: Int

    fun moTa() {
        println("Phuong tien co toc do toi da la $tocDoToiDa km/h")
    }
}

class XeMay : PhuongTienDiChuyen() {
    override val tocDoToiDa: Int = 80
}

class OTo : PhuongTienDiChuyen() {
    override val tocDoToiDa: Int = 180
}

fun main() {
    val xeMay = XeMay()
    val oTo = OTo()

    xeMay.moTa()
    oTo.moTa()
}
