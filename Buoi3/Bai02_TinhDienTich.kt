// Nguyen Thanh An - 2581001

fun tinhDienTich(chieuDai: Double, chieuRong: Double): Double {
    return chieuDai * chieuRong
}

val dienTich1: Double = tinhDienTich(5.0, 3.0)
val dienTich2: Double = tinhDienTich(7.5, 2.4)

fun main() {
    println("Dien tich 1: $dienTich1")
    println("Dien tich 2: $dienTich2")
}
