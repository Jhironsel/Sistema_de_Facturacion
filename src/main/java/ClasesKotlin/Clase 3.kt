fun main(arg:Array<String>) {
    var edad = arg[0].toString().toIntOrNull()
    
    val resultado:String = if(edad == null) "Ingresa un valor."
                            else if(edad < 18) "Menor a 18."
                            else if(edad > 18) "Mayor a 18"
                            else "Tiene justo 18"
    println(resultado)
}