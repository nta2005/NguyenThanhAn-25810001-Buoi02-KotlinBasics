// Nguyen Thanh An - 25810001

fun String.demNguyenAm(): Int {
    var dem = 0
    for (kyTu in this.lowercase()) {
        if (kyTu == 'a' || kyTu == 'e' || kyTu == 'i' || kyTu == 'o' || kyTu == 'u') {
            dem++
        }
    }
    return dem
}

fun Int.laSoNguyenTo(): Boolean {
    if (this < 2) return false
    for (i in 2 until this) {
        if (this % i == 0) return false
    }
    return true
}

fun main() {
    println("Kotlin".demNguyenAm())
    println("Xin chao cac ban".demNguyenAm())
    println("AEIOU".demNguyenAm())

    println(7.laSoNguyenTo())
    println(10.laSoNguyenTo())
    println(13.laSoNguyenTo())
}
