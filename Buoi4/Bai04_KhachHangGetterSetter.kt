// Nguyen Thanh An - 25810001

class KhachHang(var ho: String, var ten: String) {
    var hoTen: String
        get() = "$ho $ten"
        set(value) {
            val phanTach = value.split(" ", limit = 2)
            ho = phanTach[0]
            ten = if (phanTach.size > 1) phanTach[1] else ""
        }
}

fun main() {
    val kh = KhachHang("Nguyen", "Van A")
    println("Ho ten ban dau: ${kh.hoTen}")

    kh.ten = "Van B"
    println("Ho ten sau khi doi ten: ${kh.hoTen}")

    kh.hoTen = "Tran Thi C"
    println("Ho: ${kh.ho}, Ten: ${kh.ten}")
}
