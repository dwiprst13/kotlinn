fun lihat(cde: List<String>, tpe: List<String>, qnty: List<Int>, prc: List<Int>) {
    println("Lihat data di gudang")
    println("%-8s".format("Kode") + "%-23s".format("Tipe") + "%-10s".format("Jumlah") + "%-8s".format("Harga(Rp)"))
    println('-'.toString().repeat(50))
    for (index in 0 until minOf(cde.size, tpe.size, qnty.size, prc.size)) {
        val i = cde[index]
        val j = tpe[index]
        val k = qnty[index]
        val l = prc[index]
        println("%-8s".format(i) + "%-23s".format(j) + "%-10s".format(k) + "%-8s".format(l))
    }
    println()
}

fun nambah(cde: MutableList<String>, tpe: MutableList<String>, qnty: MutableList<Int>, prc: MutableList<Int>, menu: Int) {
    if (menu == 2) {
        println("Masukan data barang baru")
        println("Masukan kode barang: ")
        val incde = readLine()!!
        if (incde in cde) {
            val i = cde.indexOf(incde)
            println("Barang dengan kode $incde sudah tersedia")
            print("Silahkan masukan jumlah barang: ")
            val newqnty = readLine()!!.toInt()
            val fxQnty = qnty[i] + newqnty
            qnty[i] = fxQnty
            println()
        } else {
            cde.add(incde)
            print("Masukan tipe barang: ")
            val intpe = readLine()!!
            tpe.add(intpe)
            print("Masukan jumlah barang: ")
            val inqnty = readLine()!!.toInt()
            qnty.add(inqnty)
            print("Masukan harga barang: ")
            val inprc = readLine()!!.toInt()  // Mengubah input menjadi Int
            prc.add(inprc)
            println()
        }
    }
}


fun main() {
    println("Selamat datang di Program Admin Sederhana")
    val cde = mutableListOf("rn10", "rn11", "rn11p")
    val tpe = mutableListOf("Redmi Note 10", "Redmi Note 11", "Redmi Note 11 Pro")
    val qnty = mutableListOf(13, 23, 9)
    val prc = mutableListOf(1800500, 2250000, 4150000)
    println("  ")
    println("Daftar menu yang tersedia:")

    var menu = 1
    while (menu != 0) {
        println("1. Lihat data di gudang")
        println("2. Memasukan barang baru")
        println("3. Barang keluar")
        println("4. Menghapus Produk dari daftar")
        println("5. Ubah harga barang")
        println("0. Exit")
        println("  ")
        print("Masukan angka sesuai dengan yang anda pilih: ")
        menu = readLine()!!.toInt()
        println()

        lihat(cde, tpe, qnty, prc)
        nambah(cde, tpe, qnty, prc, menu)
    }
}
