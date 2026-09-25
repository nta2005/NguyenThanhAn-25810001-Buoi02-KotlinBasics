// Nguyen Thanh An - 2581001

fun main() {
    val tuoi: Int = 15

    val loaiVe: String = if (tuoi < 13) "Ve tre em" else if (tuoi >= 60) "Ve cao tuoi" else "Ve nguoi lon"

    println("Tuoi: $tuoi")
    println("Loai ve: $loaiVe")
}
