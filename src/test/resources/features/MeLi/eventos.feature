#language: es
Característica: Creación de eventos en Salesforce

  Antecedentes:
    Dado que el rol "Legal Ops Operaciones" ha iniciado sesión en MeLi
    Y que el rol "Legal Ops Operaciones" ha creado un caso correctamente en MeLi

  @CrearEventos
  Esquema del escenario: Crear evento según tipo de registro
    Cuando el usuario crea un nuevo evento de tipo "<tipoEvento>"
    Entonces el evento de tipo "<tipoEvento>" se crea exitosamente

    Ejemplos:
      | tipoEvento |
      | Acuerdos   |
      | Audiencia  |
      | Decisión   |
      | Multas     |
      | Pericia    |
      | Recurso    |

