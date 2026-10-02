// Nguyen Thanh An - 2581001

fun main() {
    val diemSo = arrayOf(7.5, 8.0, 6.5, 9.0, 5.5, 4.0, 10.0, 8.5, 7.0, 6.0)

    var tongDiem = 0.0
    var diemCaoNhat = diemSo[0]
    var diemThapNhat = diemSo[0]

    for (diem in diemSo) {
        tongDiem += diem
        if (diem > diemCaoNhat) {
            diemCaoNhat = diem
        }
        if (diem < diemThapNhat) {
            diemThapNhat = diem
        }
    }

    val diemTrungBinh = tongDiem / diemSo.size

    println("Diem trung binh ca lop: $diemTrungBinh")
    println("Diem cao nhat: $diemCaoNhat")
    println("Diem thap nhat: $diemThapNhat")
}
