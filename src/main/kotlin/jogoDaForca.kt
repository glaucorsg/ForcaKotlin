import java.util.*
import kotlin.math.sign
import kotlin.reflect.typeOf

fun main() {

    var desafio1: Desafio = Desafio("ROSA", "Um tipo de flor")

    var tentativa: Int = 0

    var numTentativas = ((desafio1.palavra.length) / 2) + 3

    var letra: String

    var delimiter = ""

    var palavraSplit = desafio1.palavra.split(delimiter).slice(1..contaLetras(desafio1.palavra))

    var distintas = linkedSetOf<String>()

    var corretas = linkedSetOf<String>()

    var erradas = linkedSetOf<String>()

    var oculta = arrayListOf<String>()

    var i = 0


    for (l in palavraSplit) {
        if (l in palavraSplit[i]) {
            distintas.add(l)
            i++
        }
    }

    for(l in palavraSplit) {
        oculta.add("*")
    }

    println("Olá, este é o jogo da FORCA.\n")
    println("A DICA é: ${desafio1.dica}\n")

    println("A palavra secreta contém ${contaLetras(desafio1.palavra)} letras sendo ${distintas.size} delas distintas.")
    println("Você tem um total de ${numTentativas} tentativas. \n")

    var j = 0
    while (tentativa < numTentativas && palavraSplit != oculta) {
        println("Essa é a sua ${tentativa+1}º tentativa, você possui mais ${ numTentativas- tentativa} chance(s)\n")
        println("Status do jogo: ${oculta}\n")
        println("Digite uma letra ou FIM para sair: \n")
        letra = readLine().toString().uppercase(Locale.getDefault())

        var frequencia = 0

        for(i in 0..palavraSplit.size -1) {
            if (letra == palavraSplit[i]) {
                frequencia++
                oculta[i] = letra
            }
        }

        if (letra in palavraSplit) {
            println("parabéns você acertou a letra ${letra}")
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
    println("FIM DO JOGO")
    if(erradas.size == numTentativas){
        println("GAME OVER")
    } else if (palavraSplit. equals(oculta)){
        println("PARABÉNS, VOCÊ GANHOU")
    } else null
}



    class Desafio (
        val palavra: String,
        val dica: String
    )


    fun contaLetras(palavra: String): Int {
        return palavra.length
    }



