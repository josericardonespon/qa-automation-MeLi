# Mercado Libre : QA-Automation

## Proyecto

- Implementación de testing automático



## Branch Model

- Cada sprint tiene su propio branch principal llamado: **SP[x]/main**
  - Ejemplo el sprint 1 es: **SP1/main**
- Cada __desarrollador__ desde el head (último commit) del branch main del sprint correspondiente genera un nuevo branch con el nombre **SP[x]/TQA-[nro]**
  - Ejemplo el sprint 1, la  historia de usuario US-001: **SP1/TQA-001**
- Al finalizar el desarrollo de la historia de usuario el __desarrollador__ hará un PR (pull request) desde la rama de desarrollo a la rama main
  - Desde **/SP[x]/TQA-[nro]** hacia **SP[x]/main**
    - Ejemplo el sprint 1, la  historia de usuario TQA-001: **SP1/TQA-001** hacia **SP1/main**
- __Devops__ verifica, actualiza el/los manifiesto/s  y mergea la rama

![alt text](docs/branchModel.svg)