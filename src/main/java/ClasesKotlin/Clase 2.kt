fun main() {
    
    val p1:Any=Persona("Jhironsel Diaz")
    
    print(p1)
}

class Persona(val nombre:String){
    override fun toString():String{
        return "Nombre : ${nombre}"
    }
}