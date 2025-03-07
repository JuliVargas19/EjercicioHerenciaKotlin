open class Mascotas (
    val nombre: String = ""
    val especie: String = ""
    var edad: Int = 0
    var peso: Double = 0.0
){
    fun actualizarPeso(nuevoPeso: Double){
        peso = nuevoPeso
    }
    fun incrementarEdad(){
        edad += 1
    }
    fun describrirMascota(): String{
        return "Nombre: $nombre, Especie: $especie, Edad: $edad, Peso: $peso kg"
    }
}