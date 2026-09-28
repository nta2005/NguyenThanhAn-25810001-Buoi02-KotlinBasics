// Nguyen Thanh An - 25810001

class NhanVien(maNhanVien: String, val ten: String, var luongThang: Double) {
    constructor(ten: String) : this("TAM", ten, 0.0)
}

fun main() {
    val nv1 = NhanVien("NV001", "Nguyen Van A", 8000000.0)
    val nv2 = NhanVien("Tran Thi B")

    // nv1.maNhanVien
    // Loi bien dich vi maNhanVien khong khai bao val/var nen chi la tham so cua constructor, khong phai thuoc tinh cua class

    println("NV1: ${nv1.ten}, luong: ${nv1.luongThang}")
    println("NV2: ${nv2.ten}, luong: ${nv2.luongThang}")
}
