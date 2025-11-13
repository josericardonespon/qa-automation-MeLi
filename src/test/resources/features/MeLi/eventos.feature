#language: es
Característica: Creación de eventos en Salesforce

  Antecedentes:
    Dado que el usuario ADMINISTRADOR ha iniciado sesión como Abogado Externo
    Y que el usuario desea ingresar a los casos creados en MeLi
    Y selecciona la vista de Demandas
    Y deberá visualizar los casos creados en MeLi e ingresar a un caso

  @CrearEventos
  Esquema del escenario: Crear evento según tipo de registro
    Cuando el usuario crea un nuevo evento de tipo "<tipoEvento>"
    Entonces el evento de tipo "<tipoEvento>" se crea exitosamente

    Ejemplos:
      | tipoEvento |
      | Acuerdos   |
      | Audiencia  |

