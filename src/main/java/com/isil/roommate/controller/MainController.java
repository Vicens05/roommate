package com.isil.roommate.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.isil.roommate.entity.User;
import com.isil.roommate.repository.UserRepository;
import javax.validation.Valid;

/**
 * Clase controladora responsable de gestionar las solicitudes relacionadas con las páginas principales.
 */
@Controller
@RequestMapping
public class MainController {

    /**
     * Maneja la solicitud GET para el punto de conexión raíz ("/") con el fin de mostrar la página principal.
     * Determina la vista adecuada según el rol del usuario y establece el atributo "view" en el modelo.
     * Esto asegura que se renderice la plantilla Thymeleaf correcta, evitando un error 505 en el primer inicio
     * de sesión cuando la variable "view" es nula. El valor predeterminado para el atributo "view" se establece
     * en "admin/index" para usuarios con el rol "ROLE_ADMIN".
     *
     * @param aware  Una instancia de {@link SecurityContextHolderAwareRequestWrapper}
     *               que representa el contexto de seguridad del usuario autenticado.
     * @param model  El modelo de Spring MVC para agregar atributos que se utilizarán en la vista.
     * @return El nombre lógico de la vista (plantilla Thymeleaf) a renderizar según el rol del usuario.
     */
    @GetMapping("/")
    public String index(SecurityContextHolderAwareRequestWrapper aware, Model model) {
        // TODO: ROLE_RECEPCIONISTA
        if (aware.isUserInRole("ROLE_ADMIN")) {
            // Establece el atributo "view" con el valor predeterminado o el valor especificado por el atributo flash "view".
            model.addAttribute("view", model.asMap().getOrDefault("view", "admin/index"));
        }
        return "index";
    }

    /**
     * Maneja la solicitud GET para el endpoint "/login", mostrando la página de inicio de sesión.
     *
     * @return La cadena que representa el nombre lógico de la vista (Thymeleaf template) para la página de inicio de sesión.
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
