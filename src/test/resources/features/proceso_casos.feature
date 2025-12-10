#language: es
Característica: Proceso de Casos E2E

  @FlujosCompletosConEventos
  Esquema del escenario: Flujo E2E exitoso para caso con rol <rol> y evento <tipoEvento>

    Dado que el rol "<rol>" ha iniciado sesión en MeLi
    Cuando el rol "<rol>" ha creado un caso correctamente en MeLi
    Y el usuario crea un nuevo evento de tipo "<tipoEvento>"
    Entonces el evento de tipo "<tipoEvento>" se crea exitosamente

    Ejemplos:
      | rol                   | tipoEvento |
      | BPO Operaciones       | Acuerdo    |
      | BPO Operaciones       | Audiencia  |
      | BPO Operaciones       | Decisión   |
      | BPO Operaciones       | Multa      |
      | BPO Operaciones       | Pericia    |
      | BPO Operaciones       | Recurso    |
      | Legal Ops Operaciones | Acuerdo    |
      | Legal Ops Operaciones | Audiencia  |
      | Legal Ops Operaciones | Decisión   |
      | Legal Ops Operaciones | Multa      |
      | Legal Ops Operaciones | Pericia    |
      | Legal Ops Operaciones | Recurso    |
      | Admin Meli            | Acuerdo    |
      | Admin Meli            | Audiencia  |
      | Admin Meli            | Decisión   |
      | Admin Meli            | Multa      |
      | Admin Meli            | Pericia    |
      | Admin Meli            | Recurso    |



