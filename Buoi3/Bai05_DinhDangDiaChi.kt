// Nguyen Thanh An - 2581001

fun dinhDangDiaChi(
    soNha: String,
    tenDuong: String,
    phuong: String = "Khong xac dinh",
    quan: String = "Khong xac dinh",
    thanhPho: String = "TP Ho Chi Minh"
): String {
    return "$soNha $tenDuong, $phuong, $quan, $thanhPho"
}

fun main() {
    val diaChi = dinhDangDiaChi(
        "123",
        "Nguyen Trai",
        phuong = "Phuong 5",
        quan = "Quan 5",
        thanhPho = "TP Ho Chi Minh"
    )
    println(diaChi)
}
