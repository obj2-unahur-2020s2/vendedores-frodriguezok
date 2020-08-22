package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class VendedorTest : DescribeSpec({
  val misiones = Provincia(1300000)
  val sanIgnacio = Ciudad(misiones)

  describe("Vendedor fijo") {
    val obera = Ciudad(misiones)
    val vendedorFijo = VendedorFijo(obera)

    describe("puedeTrabajarEn") {
      it("su ciudad de origen") {
        vendedorFijo.puedeTrabajarEn(obera).shouldBeTrue()
      }
      it("otra ciudad") {
        vendedorFijo.puedeTrabajarEn(sanIgnacio).shouldBeFalse()
      }
    }
  }

  describe("Viajante") {
    val cordoba = Provincia(2000000)
    val villaDolores = Ciudad(cordoba)
    val viajante = Viajante(listOf(misiones))

    describe("puedeTrabajarEn") {
      it("una ciudad que pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(sanIgnacio).shouldBeTrue()
      }
      it("una ciudad que no pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(villaDolores).shouldBeFalse()
      }
    }
  }

  describe("Comercio Corresponsal") {
    val buenosAires = Provincia(poblacion = 2890000)
    val santaFe = Provincia(poblacion = 3285170)
    val cordoba = Provincia(poblacion = 1391000)
    val entreRios = Provincia(poblacion = 1308000)

    val chivilcoy = Ciudad(buenosAires)
    val bragado  = Ciudad(buenosAires)
    val lobos = Ciudad(buenosAires)
    val pergamino = Ciudad(buenosAires)
    val zarate = Ciudad(buenosAires)
    val rosario = Ciudad(santaFe)
    val rafaela = Ciudad(santaFe)
    val sanFrancisco = Ciudad(cordoba)
    val diamante = Ciudad(entreRios)
    val amstrong = Ciudad(santaFe)

    describe("Comercio1") {
      val comercio1 = ComercioCorresponsal(listOf(chivilcoy,bragado,lobos,pergamino,zarate))
      it("es influyente"){
      comercio1.influyente().shouldBeTrue()
    }}

    describe("Comercio2") {
      val comercio2 = ComercioCorresponsal(listOf(rosario,rafaela,sanFrancisco,diamante))
      it("es Influyente"){
        comercio2.influyente().shouldBeTrue()
      }
    }

    describe("comercio3"){
      val comercio3 = ComercioCorresponsal(listOf(rosario,rafaela,amstrong,diamante))
      it("no es influyente"){
        comercio3.influyente().shouldBeFalse()
      }
    }
  }
})