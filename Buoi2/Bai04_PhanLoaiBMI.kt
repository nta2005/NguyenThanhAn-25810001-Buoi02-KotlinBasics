// Nguyen Thanh An - 2581001

fun main() {
    val canNang: Double = 65.0
    val chieuCao: Double = 1.7

    val bmi: Double = canNang / (chieuCao * chieuCao)

    val phanLoai: String
    if (bmi < 18.5) {
        phanLoai = "Gay"
    } else if (bmi < 25.0) {
        phanLoai = "Binh thuong"
    } else if (bmi < 30.0) {
        phanLoai = "Thua can"
    } else {
        phanLoai = "Beo phi"
    }

    println("Can nang: $canNang kg, Chieu cao: $chieuCao m")
    println("Chi so BMI: $bmi")
    println("Phan loai: $phanLoai")
}
