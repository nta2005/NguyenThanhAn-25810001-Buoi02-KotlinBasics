// Nguyen Thanh An - 2581001

fun main() {
    val diemTrungBinh: Double = 7.8

    val xepLoai: String = when (diemTrungBinh) {
        in 9.0..10.0 -> "Xuat sac"
        in 8.0..8.9 -> "Gioi"
        in 6.5..7.9 -> "Kha"
        in 5.0..6.4 -> "Trung binh"
        else -> "Yeu"
    }

    println("Diem trung binh: $diemTrungBinh")
    println("Xep loai hoc luc: $xepLoai")
}
