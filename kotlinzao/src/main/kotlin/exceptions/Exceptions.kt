package br.com.seteideias.exceptions

class Exceptions {
    fun venderChurros(qtd: Int): Result<Int> {
        return if (qtd <= 0) {
            Result.failure(IllegalArgumentException("Quantidade inválida"))
        } else {
            Result.success(qtd * 5) // preço
        }
    }
}

fun main() {
    val r1 = Exceptions().venderChurros(2)
    val r2 = Exceptions().venderChurros(0)

    println(r1.getOrElse { -1 }) // 10
    println(r2.getOrElse { -1 }) // -1
}
