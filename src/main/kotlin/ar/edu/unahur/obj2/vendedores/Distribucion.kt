package ar.edu.unahur.obj2.vendedores

class CentroDeDistribucion(var ciudad: Ciudad) {
    val vendedores = mutableSetOf<Vendedor>()

    fun vendedorDelCentro(unVendedor: Vendedor){
        if(vendedores.contains(unVendedor)) {
            throw Exception ("El vendedor ya esta trabajando en nuestro centro de distribucion")
        }else{
            vendedores.add(unVendedor)
        }
    }

    fun vendedorEstrella(): Vendedor? {
        return vendedores.maxBy({v -> v.sumarCertificaciones()})
    }

    fun puedeCubrir(unaCiudad: Ciudad): Boolean {
        return vendedores.any({v -> v.puedeTrabajarEn(unaCiudad)})
    }

    fun vendedoresGenericos(): List<Vendedor> {
        return vendedores.filter({ v -> v.certificadoNoPorProducto()})
    }

    fun esRobusto(): Boolean{
        return vendedores.filter({v -> v.firme()}).size >= 3
    }

}