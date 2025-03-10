fun main() {

    val mascotas = mutableListOf<Mascota>()
    val consultas = mutableListOf<ConsultaMedica>()

    while (true) {
        println("\nSistema de Gestión Veterinaria")
        println("1. Registrar mascota")
        println("2. Mostrar mascotas")
        println("3. Registrar consulta médica")
        println("4. Mostrar historial de consultas")
        println("5. Modificar peso o edad de una mascota")
        println("6. Calcular costo total de consultas de una mascota")
        println("7. Salir")
        print("Selecciona una opción: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Nombre: ")
                val nombre = readLine() ?: ""
                print("Especie: ")
                val especie = readLine() ?: ""
                print("Edad: ")
                val edad = readLine()?.toIntOrNull() ?: 0
                print("Peso: ")
                val peso = readLine()?.toDoubleOrNull() ?: 0.0
                mascotas.add(Mascota(nombre, especie, edad, peso))
                println("Mascota registrada con éxito.")
            }
            2 -> {
                if (mascotas.isEmpty()) println("No hay mascotas registradas.")
                else mascotas.forEach { println(it.describirMascota()) }
            }
            3 -> {
                if (mascotas.isEmpty()) {
                    println("No hay mascotas registradas.")
                    continue
                }
                println("Seleccione una mascota por índice:")
                mascotas.forEachIndexed { index, mascota -> println("$index - ${mascota.nombre}") }
                val index = readLine()?.toIntOrNull() ?: continue
                if (index !in mascotas.indices) continue
                print("Diagnóstico: ")
                val diagnostico = readLine() ?: ""
                print("Costo base: ")
                val costoConsulta = readLine()?.toDoubleOrNull() ?: 0.0
                print("¿Incluye medicación? (s/n): ")
                val incluyeMedicacion = readLine()?.lowercase() == "s"
                consultas.add(
                    ConsultaMedica(
                        mascotas[index].nombre,
                        mascotas[index].especie,
                        mascotas[index].edad,
                        mascotas[index].peso,
                        diagnostico,
                        costoConsulta
                    )
                )
                println("Consulta registrada.")
            }
            4 -> {
                if (consultas.isEmpty()) println("No hay consultas registradas.")
                else consultas.forEach { println("Mascota: ${it.nombre}, Diagnóstico: ${it.diagnostico}, Costo: ${it.calcularCosto(true)}") }
            }
            5 ->  {
            println("Seleccione una mascota por índice:")
            mascotas.forEachIndexed { index, mascota -> println("$index - ${mascota.nombre}") }
            val index = readLine()?.toIntOrNull() ?: continue
            if (index !in mascotas.indices) continue
            print("Nuevo peso (dejar vacío para no cambiar): ")
            val nuevoPeso = readLine()?.toDoubleOrNull()
            print("Nueva edad (dejar vacío para no cambiar): ")
            val nuevaEdad = readLine()?.toIntOrNull()
            nuevoPeso?.let { mascotas[index].actualizarPeso(it) }
            nuevaEdad?.let { mascotas[index].edad = it }
            println("Datos actualizados.")
        }

            6 -> {
                println("Seleccione una mascota por índice:")
                mascotas.forEachIndexed { index, mascota -> println("$index - ${mascota.nombre}") }
                val index = readLine()?.toIntOrNull() ?: continue
                if (index !in mascotas.indices) continue
                val totalCosto = consultas.filter { it.nombre == mascotas[index].nombre }.sumOf { it.calcularCosto(true) }
                println("Costo total de consultas: $totalCosto")
            }
            7 -> {
                println("Saliendo del sistema...")
                break
            }
            else -> println("Opción no válida.")
        }
    }
}

