// Nguyen Thanh An - 2581001

fun main() {
    var soHienTai = 0
    var soTiepTheo = 1

    for (viTri in 0 until 50) {
        if (soHienTai >= 100) {
            break
        }
        println("Vi tri $viTri: $soHienTai")

        val tong = soHienTai + soTiepTheo
        soHienTai = soTiepTheo
        soTiepTheo = tong
    }
}
