package org.example

import org.w3c.dom.Document
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

class GestorFich {

    fun lectorFich(file: File): List<Empleado>{
        val listaEmpleado = mutableListOf<Empleado>()

        file.forEachLine { linea ->
            val contenido = linea.split(",")
            if (contenido[0] != "ID"){
                val id = contenido[0].toIntOrNull() ?: 0 // <- Lo convierto a Int porque de lo contrario al ordenarlo sigue el patrón 1, 11, 12 . . . en lugar de 1, 2, 3 . . .
                val apellido = contenido[1]
                val departamento = contenido[2]
                val salario = contenido[3].toDoubleOrNull() ?: 0.0

                listaEmpleado.add(Empleado(id, apellido, departamento, salario))
            }
        }

        return listaEmpleado.sortedBy { it.id }
    }

    fun escritorFich(list: List<Empleado>){

        val db = DocumentBuilderFactory.newInstance()
        val builder = db.newDocumentBuilder()
        val imp = builder.domImplementation

    }
}