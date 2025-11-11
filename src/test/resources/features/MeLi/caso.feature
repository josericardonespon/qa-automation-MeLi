#language: es
Característica: Ingresar a caso

  Antecedentes:
    Dado que el usuario ADMINISTRADOR ha iniciado sesión como Abogado Externo

  @IngresarCasoCreado
  Escenario: Ingresar a un caso creado a traves de MeLi
    Dado que el usuario desea ingresar a los casos creados en MeLi
    Cuando selecciona la vista de Demandas
    Entonces deberá visualizar los casos creados en MeLi e ingresar a un caso