import java.util.*
import kotlin.reflect.typeOf

fun main() {

    val desafio1: Desafio = Desafio("ARMARIO", "Guarda coisas")

    var tentativa: Int = 0

    var numTentativas = ((desafio1.palavra.length) / 2) + 1

    var letra: String

    var delimiter = ""

    var palavraSplit = desafio1.palavra.split(delimiter).slice(1..contaLetras(desafio1.palavra))

    var distintas = linkedSetOf<String>()

    var corretas = linkedSetOf<String>()

    var erradas = linkedSetOf<String>()

    var i = 0
    for (letra in palavraSplit) {
        if (letra in palavraSplit[i]) {
            distintas.add(letra)
            i++
        }
    }

    println(
        "Olá, este é o jogo da FORCA. Você deve advinhar a palavra secreta.\n\n" +
                "A DICA é: ${desafio1.dica}\n")

    println("A palavra secreta contém ${contaLetras(desafio1.palavra)} letras sendo ${distintas.size} delas distintas.")
    println("Você tem um total de ${numTentativas} tentativas.")

    while (tentativa < numTentativas) {
        println("Essa é a sua ${tentativa+1}º tentativa, você possui mais ${ numTentativas- tentativa} chance(s)")
        println("Digite uma letra ou FIM para sair: ")
        letra = readLine().toString().uppercase(Locale.getDefault())

        if (letra in distintas) {
            println("Você acertou a letra ${letra}")
            corretas.add(letra)
            tentativa++
        }
        else {
            println("A letra ${letra} não está presente na palavra")
            erradas.add(letra)
            tentativa++
        }
        println("ACERTOS: ${corretas}")
        println("ERROS: ${erradas}")
    }

}
    class Desafio(
        val palavra: String,
        val dica: String
    )

    fun contaLetras(palavra: String): Int {
        return palavra.length
    }



