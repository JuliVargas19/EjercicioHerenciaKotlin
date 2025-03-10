class ConsultaMedica(
    nombre: String,
    especie: String,
    edad: Int,
    peso: Double,
    diagnostico: String,
    costoConsulta: Double
) : Mascota(nombre,especie,edad,peso) {

    var diagnostico: String = ""
    var costoConsulta: Double = 0.0

    fun calcularCosto(incluyeMedicacion: Boolean): Double {
        return if (incluyeMedicacion) costoConsulta * 1.15 else costoConsulta
    }

    fun describirConsulta(): String {
        return "Mascota: $nombre, Diagnóstico: $diagnostico, Costo: ${calcularCosto(true)}$"
    }

}