// Nguyen Thanh An - 2581001

fun main() {
    val soLuong: Int = 5
    val donGia: Double = 25000.0

    val tienHang: Double = soLuong.toDouble() * donGia
    val thue: Double = tienHang * 0.08
    val tongTien: Double = tienHang + thue

    println("So luong san pham: $soLuong")
    println("Don gia: $donGia VND")
    println("Tien hang (chua thue): $tienHang VND")
    println("Thue (8%): $thue VND")
    println("Tong tien phai tra: $tongTien VND")
}
