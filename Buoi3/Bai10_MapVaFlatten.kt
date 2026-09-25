// Nguyen Thanh An - 2581001

fun main() {
    val danhSachSo = listOf(1, 2, 3, 4, 5)
    val danhSachNhanDoi = danhSachSo.map { it * 2 }
    println("Danh sach nhan doi: $danhSachNhanDoi")

    val danhSachLongNhau = listOf(listOf(1, 2), listOf(3, 4, 5), listOf(6))
    val danhSachPhang = danhSachLongNhau.flatten()
    println("Danh sach phang: $danhSachPhang")
}
