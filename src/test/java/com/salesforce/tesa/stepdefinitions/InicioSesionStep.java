package com.salesforce.tesa.stepdefinitions;

import com.salesforce.tesa.tasks.CambiarRolTask;
import com.salesforce.tesa.tasks.CerrarSesionTask;
import com.salesforce.tesa.tasks.InicioSesionTask;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.salesforce.tesa.userintefaces.InicioSesionPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class InicioSesionStep {



    @Cuando("el usuario inicia sesión como ADMINISTRADOR en MeLi")
    public void elUsuarioAdminHaIniciaSesion() {
        OnStage.theActorInTheSpotlight().attemptsTo(InicioSesionTask.conCredencialesValidas());
    }

    @Entonces("el usuario accede a Salesforce")
    public void accedeALaPaginaPrincipalDeLaORG() {
        Ensure.that(BARRA_CERRAR_SESION).isDisplayed();
    }

    @Dado("que el usuario ADMINISTRADOR ha iniciado sesión como {string}")
    public void elUsuarioAdminHaIniciaSesionComo(String rol) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CambiarRolTask.a(rol)
        );
    }

    @Dado("Se cierra sesion e inicia sesión como {string} en MeLi")
    public void elUsuarioCambiaDeRol(String rol) {
        // Cierra sesion
        theActorInTheSpotlight().attemptsTo(CerrarSesionTask.cerrarSesion());
        elUsuarioAdminHaIniciaSesion();
        accedeALaPaginaPrincipalDeLaORG();
        elUsuarioAdminHaIniciaSesionComo(rol);
        // Inicia sesion con el nuevo rol que le enviamos por parametro
        //OnStage.theActorInTheSpotlight().attemptsTo(InicioSesionTask.inicioSesionConRol(rol));
    }

    @Dado("que el rol {string} ha iniciado sesión en MeLi")
    public void rolIniciaSesion(String rol) {
        elUsuarioAdminHaIniciaSesion();
        accedeALaPaginaPrincipalDeLaORG();
        elUsuarioAdminHaIniciaSesionComo(rol);
    }

    @Y("Se cierra sesion e inicia sesión con usuario asignado a la solicitud")
    public void seCierraSesionEIniciaSesionComoUsuarioAsignadoAlaSolicitud() {
        String usuarioAsignado = theActorInTheSpotlight().recall("usuario_asignado");
        if (usuarioAsignado.equals("Data Entry: Interno")) {
            usuarioAsignado = "Data Entry Interno";
        }
        theActorInTheSpotlight().attemptsTo(CerrarSesionTask.cerrarSesion());
        elUsuarioAdminHaIniciaSesion();
        accedeALaPaginaPrincipalDeLaORG();
        elUsuarioAdminHaIniciaSesionComo(usuarioAsignado);
    }

}

