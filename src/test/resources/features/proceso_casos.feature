#language: es
Característica: Proceso de Casos E2E

  @FlujosCompletos
  Esquema del escenario: Flujo E2E exitoso para caso con rol <rol> y evento <tipoEvento>

    Dado que el rol "<rol>" ha iniciado sesión en MeLi
    Cuando que el rol "<rol>" ha creado un caso correctamente en MeLi
    Y el usuario crea un nuevo evento de tipo "<tipoEvento>"
    Y el evento de tipo "<tipoEvento>" se crea exitosamente

    Ejemplos:
      | rol                    | tipoEvento |
      | Legal Ops Operaciones | Acuerdos   |
      | Legal Ops Operaciones | Audiencia  |
      | Legal Ops Operaciones | Decisión   |
      | Legal Ops Operaciones | Multas     |
      | Legal Ops Operaciones | Pericia    |
      | Legal Ops Operaciones | Recurso    |
      | Admin Meli            | Acuerdos   |
      | Admin Meli            | Audiencia  |
      | Admin Meli            | Decisión   |
      | Admin Meli            | Multas     |
      | Admin Meli            | Pericia    |
      | Admin Meli            | Recurso    |



