#language: es
Característica: Crear Casos a través de MeLi

  Antecedentes:
    Dado que el rol "Legal Ops Operaciones" ha iniciado sesión en MeLi

  @CrearCasos
  Escenario: Crear a un caso nuevo a traves de MeLi
    Dado que el usuario desea crear un caso en MeLi
    Cuando selecciona la vista de Demandas
    Y crea un nuevo caso
    Entonces deberá visualizar e ingresar al caso creado en MeLi correctamente