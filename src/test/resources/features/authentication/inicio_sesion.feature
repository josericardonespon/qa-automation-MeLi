#language: es
Característica: Inicio sesion exitoso en la ORG de Salesforce

  @InicioSesion
  Esquema del escenario: Inicio sesion exitoso en la ORG de Salesforce
    Cuando el usuario inicia sesión como ADMINISTRADOR en MeLi
    Entonces que el usuario ADMINISTRADOR ha iniciado sesión como "<rol>"

    Ejemplos:
      | rol                     |
      | Legal Ops Operaciones   |
      | BPO Operaciones         |
      | Admin Meli              |
