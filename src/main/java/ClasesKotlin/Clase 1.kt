fun main(arg:Array<String>) {
    val numeros = arg.map{it.toInt()}.toIntArray()
    val sumados = numeros.sum()
    
    println("La suma de los valores son $sumados y la cantidad de elementos son ${numeros.size}")
    
    println("Lista de elemento: ")
    
    for(numero in numeros){
        println("Numero: ${numero}")
    }
}