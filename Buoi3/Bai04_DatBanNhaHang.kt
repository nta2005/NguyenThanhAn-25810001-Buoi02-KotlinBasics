// Nguyen Thanh An - 2581001

fun datBan(tenKhachHang: String, soLuongKhach: Int, loaiBan: String = "Ban thuong") {
    println("Khach hang: $tenKhachHang, So luong khach: $soLuongKhach, Loai ban: $loaiBan")
}

fun main() {
    datBan("Nguyen Van A", 4)
    datBan("Tran Thi B", 2, "Ban VIP")
    datBan(tenKhachHang = "Le Van C", soLuongKhach = 6, loaiBan = "Ban ngoai troi")
}
