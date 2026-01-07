#language: es
Característica: Proceso de solicitud

  Antecedentes:
    Dado que el rol "BPO Operaciones" ha iniciado sesión en MeLi
    Y el rol "BPO Operaciones" ha creado un caso correctamente en MeLi

  @CrearSolicitudes
  Esquema del escenario: Creacion de solicitud de tipo <tipoSolicitud> con rol <rol>

    Dado Se cierra sesion e inicia sesión como "Abogado Interno" en MeLi
    Cuando el rol "Abogado Interno" ingresa a un caso previamente creado
    Y el usuario crea una solicitud de tipo "<tipoSolicitud>"
    Y la solicitud de tipo "<tipoSolicitud>" se visualiza exitosamente
    Y Se cierra sesion e inicia sesión con usuario asignado a la solicitud
    Y el Usuario Asignado ingresa a la solicitud previamente creada
    Y el Usuario Asignado resuelve la solicitud de tipo "<tipoSolicitud>"
    Entonces la solicitud se resuelve exitosamente

    Ejemplos:
      | tipoSolicitud               |
      | Corrección Registro         |
#      | Complementación información |
#      | Actuación                   |
#      | Validación escritos         |


