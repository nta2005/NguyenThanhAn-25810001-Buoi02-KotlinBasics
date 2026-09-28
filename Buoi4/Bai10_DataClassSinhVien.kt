// Nguyen Thanh An - 25810001

data class SinhVien(val mssv: String, val hoTen: String, val diemTrungBinh: Double)

fun main() {
    val sv1 = SinhVien("SV001", "Nguyen Thanh An", 8.5)
    val sv2 = SinhVien("SV001", "Nguyen Thanh An", 8.5)

    println(sv1)
    println("So sanh sv1 == sv2: ${sv1 == sv2}")

    val sv3 = sv1.copy(diemTrungBinh = 9.0)
    println(sv3)
}
