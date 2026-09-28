// Nguyen Thanh An - 25810001

class TaiKhoanNganHang(val soTaiKhoan: String, soDuBanDau: Double) {
    var soDu = soDuBanDau

    init {
        if (soDuBanDau < 0) {
            println("So du khong hop le")
        } else {
            println("Tao tai khoan thanh cong, so du ban dau: $soDuBanDau")
        }
    }
}

fun main() {
    val tk1 = TaiKhoanNganHang("TK001", 1000000.0)
    val tk2 = TaiKhoanNganHang("TK002", -500000.0)
}
