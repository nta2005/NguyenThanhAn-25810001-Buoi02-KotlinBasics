// Nguyen Thanh An - 2581001

fun tinhDoDaiTen(ten: String?): Int? {
    return ten?.length
}

fun layTenHienThi(ten: String?): String {
    return ten ?: "Khach vang lai"
}

fun main() {
    val tenKhachHang1: String? = "Nguyen Van A"
    val tenKhachHang2: String? = null

    println("Do dai ten khach hang 1: ${tinhDoDaiTen(tenKhachHang1)}")
    println("Do dai ten khach hang 2: ${tinhDoDaiTen(tenKhachHang2)}")

    println("Ten hien thi 1: ${layTenHienThi(tenKhachHang1)}")
    println("Ten hien thi 2: ${layTenHienThi(tenKhachHang2)}")

    val tenChacChanKhongNull: String? = "Tran Thi B"
    val doDaiTenChacChan = tenChacChanKhongNull!!.length
    println("Do dai ten (dung !!, chac chan khong null): $doDaiTenChacChan")
}
