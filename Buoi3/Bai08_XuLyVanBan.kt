// Nguyen Thanh An - 2581001

fun xuLyVanBan(vanBan: String, xuLy: (String) -> String): String {
    return xuLy(vanBan)
}

fun vietHoaToanBo(vanBan: String): String {
    return vanBan.uppercase()
}

fun main() {
    val ketQua1 = xuLyVanBan("hello kotlin", { it.reversed() })
    val ketQua2 = xuLyVanBan("hello kotlin", ::vietHoaToanBo)
    val ketQua3 = xuLyVanBan("hello kotlin") { it.trim() }

    println(ketQua1)
    println(ketQua2)
    println(ketQua3)
}
