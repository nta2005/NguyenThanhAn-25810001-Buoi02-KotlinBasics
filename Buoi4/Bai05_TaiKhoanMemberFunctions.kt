// Nguyen Thanh An - 25810001

class TaiKhoanNganHang(val soTaiKhoan: String, soDuBanDau: Double) {
    var soDu = soDuBanDau

    fun napTien(soTien: Double) {
        soDu += soTien
    }

    fun rutTien(soTien: Double): Boolean {
        if (soDu >= soTien) {
            soDu -= soTien
            return true
        }
        return false
    }
}

fun main() {
    val tk = TaiKhoanNganHang("TK001", 1000000.0)

    tk.napTien(500000.0)
    println("So du sau khi nap tien: ${tk.soDu}")

    val ketQua1 = tk.rutTien(2000000.0)
    println("Rut 2000000 thanh cong: $ketQua1, so du: ${tk.soDu}")

    val ketQua2 = tk.rutTien(1000000.0)
    println("Rut 1000000 thanh cong: $ketQua2, so du: ${tk.soDu}")
}
