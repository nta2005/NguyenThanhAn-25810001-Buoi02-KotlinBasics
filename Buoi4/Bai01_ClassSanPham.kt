// Nguyen Thanh An - 25810001

class SanPham(val tenSanPham: String, val gia: Double, val soLuongTonKho: Int = 0)

fun main() {
    val sp1 = SanPham("Ban phim", 250000.0, 10)
    val sp2 = SanPham(tenSanPham = "Chuot may tinh", gia = 150000.0)

    println("San pham 1: ${sp1.tenSanPham}, gia: ${sp1.gia}, ton kho: ${sp1.soLuongTonKho}")
    println("San pham 2: ${sp2.tenSanPham}, gia: ${sp2.gia}, ton kho: ${sp2.soLuongTonKho}")
}
