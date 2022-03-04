import java.util.*
import kotlin.reflect.typeOf

fun main() {

    var desafio1: Desafio = Desafio("ARMARIO", "Guarda as coisas")

    var tentativa: Int = 0

    var numTentativas = ((desafio1.palavra.length) / 2) + 2

    var letra: String

    var delimiter = ""

    var palavraSplit = desafio1.palavra.split(delimiter).slice(1..contaLetras(desafio1.palavra))

    var distintas = mutableListOf<String>()

    var corretas = mutableListOf<String>()

    var erradas = mutableListOf<String>()

    var oculta = mutableListOf<String>()

    var temporaria = mutableListOf<String>()

    temporaria = palavraSplit as MutableList<String>

    println("temporaria: ${temporaria}")

    var i = 0
    var aux: Boolean = false

    for (l in palavraSplit) {
        for (m in temporaria) {
            println("l: ${l} -- m: ${m}")
            if (l.equals(m)) {
                aux = true
            }
        }
        println(aux)
        if (!aux) {
            println("passou aqui")
            distintas.add(l)
        }
    }
//        if(palavraSplit[i] == l){
//            println("palavraSplit[${i}]: ${palavraSplit[i]} --- l: ${l}")
//            i++

//        } else {
//            distintas.add(palavraSplit[i])
//            i++
//        }




    println("distintas: ${distintas}")
    println("palavraSplit: ${ palavraSplit }")

    for(l in palavraSplit) {
        oculta.add("*")
    }

    println(
        "Olá, este é o jogo da FORCA. Você deve advinhar a palavra secreta.\n\n" +
                "A DICA é: ${desafio1.dica}\n")

    println("A palavra secreta contém ${contaLetras(desafio1.palavra)} letras sendo ${distintas.size} delas distintas.")
    println("Você tem um total de ${numTentativas} tentativas. \n")

    var j = 0
    while (tentativa < numTentativas) {
        println("Essa é a sua ${tentativa+1}º tentativa, você possui mais ${ numTentativas- tentativa} chance(s)\n")
        println("Status do jogo: ${oculta}\n")
        println("Digite uma letra ou FIM para sair: \n")
        letra = readLine().toString().uppercase(Locale.getDefault())

        println(letra)
        println(palavraSplit)

            if (letra in palavraSplit) {
                tentativa++
                for (l in palavraSplit) {
                    var index = palavraSplit.indexOf(letra)
                    println("Você acertou a letra ${letra}")
                    corretas.add(letra)
                    oculta.set(index, letra.toString())
                    j++
                    println(oculta)
                }
            }

            else {
                println("A letra ${letra} não está presente na palavra")
                erradas.add(letra)
                tentativa++
            }
    }




    println("ACERTOS: ${corretas}")
    println("ERROS: ${erradas}")

}



    class Desafio (
        val palavra: String,
        val dica: String
    )


    fun contaLetras(palavra: String): Int {
        return palavra.length
    }



