// Nguyen Thanh An - 2581001

fun main() {
    val soDuBanDau: Double = 5_000_000.0
    var soDuHienTai: Double = soDuBanDau

    println("So du ban dau: $soDuBanDau VND")

    soDuHienTai += 2_000_000.0
    println("Sau khi gui them 2,000,000 VND -> so du: $soDuHienTai VND")

    soDuHienTai -= 1_500_000.0
    println("Sau khi rut 1,500,000 VND -> so du: $soDuHienTai VND")

    println("So du ban dau (doi chieu, khong doi): $soDuBanDau VND")
}
