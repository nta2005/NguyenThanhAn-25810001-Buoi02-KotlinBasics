// Nguyen Thanh An - 2581001

fun main() {
    val nhacCu = listOf("Piano", "Guitar", "Trong", "Violin", "Trumpet", "Flute", "Cello", "Trombone")
    val chuCai = 'T'

    val locEager = nhacCu.filter { it.startsWith(chuCai) }
    println("Loc eager: $locEager")

    // Nen dung Sequence khi danh sach lon va can noi tiep nhieu phep bien doi, vi no danh gia lazy tung phan tu thay vi tao danh sach trung gian cho moi buoc.
    val locLazy = nhacCu.asSequence().filter { it.startsWith(chuCai) }.toList()
    println("Loc lazy: $locLazy")
}
