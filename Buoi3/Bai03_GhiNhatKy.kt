// Nguyen Thanh An - 2581001

fun ghiNhatKyTuongMinh(hanhDong: String): Unit {
    println("[LOG] $hanhDong")
}

fun ghiNhatKyNgamDinh(hanhDong: String) {
    println("[LOG] $hanhDong")
}

// Hai cach viet tuong duong vi Unit la kieu tra ve mac dinh, trinh bien dich tu suy luan giong het truong hop khai bao tuong minh.
fun main() {
    ghiNhatKyTuongMinh("Dang nhap he thong")
    ghiNhatKyNgamDinh("Dang nhap he thong")
}
