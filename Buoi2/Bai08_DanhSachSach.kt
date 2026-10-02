// Nguyen Thanh An - 2581001

fun main() {
    val danhSachSach = mutableListOf(
        "Dac Nhan Tam",
        "Nha Gia Kim",
        "Toi Tai Gioi Ban Cung The",
        "Cafe Cung Andy",
        "Doc Vi Bat Ky Ai"
    )

    println("Danh sach ban dau: $danhSachSach")

    danhSachSach.add("Nghi Giau Lam Giau")
    danhSachSach.add("Tu Duy Nhanh Va Cham")

    danhSachSach.remove("Cafe Cung Andy")

    danhSachSach.sort()

    println("Danh sach sau khi them, xoa, sap xep: $danhSachSach")
}
