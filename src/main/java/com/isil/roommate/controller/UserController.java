package com.isil.roommate.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.isil.roommate.entity.User;
import com.isil.roommate.repository.UserRepository;
import javax.validation.Valid;

/**
 * Controlador encargado de gestionar las operaciones relacionadas con los usuarios en el rol de administrador.
 */
@Controller
@RequestMapping("/admin")
@Secured("ROLE_ADMIN")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Maneja la solicitud GET para el endpoint "/admin" redirigiendo a la página principal del área de administración.
     * Añade el atributo flash "view" con el valor "admin/index" para especificar la vista a renderizar.
     *
     * @param red  Instancia de {@link RedirectAttributes} para añadir atributos a la redirección.
     * @return La redirección a la página principal ("/") con el atributo "view" especificado.
     */
    @GetMapping
    public String index(RedirectAttributes red) {
        red.addFlashAttribute("view", "admin/index");
        return "redirect:/";
    }

    /**
     * Maneja la solicitud GET para el endpoint "/admin/usuarios" redirigiendo a la página de visualización de usuarios.
     * Añade el atributo flash "view" con el valor "admin/read" para especificar la vista a renderizar.
     *
     * @param red  Instancia de {@link RedirectAttributes} para añadir atributos a la redirección.
     * @return La redirección a la página principal ("/") con el atributo "view" especificado.
     */
    @GetMapping("/usuarios")
    public String list(RedirectAttributes red) {
        red.addFlashAttribute("view", "admin/list");
        return "redirect:/";
    }

    /**
     * Maneja la solicitud GET para el endpoint "/admin/usuarios/crear" redirigiendo a la página de creación de usuarios.
     * Añade el atributo flash "view" con el valor "admin/create" para especificar la vista a renderizar.
     *
     * @param red  Instancia de {@link RedirectAttributes} para añadir atributos a la redirección.
     * @return La redirección a la página principal ("/") con el atributo "view" especificado.
     */
    @GetMapping("/usuarios/crear")
    public String create(RedirectAttributes red) {
        red.addFlashAttribute("view", "admin/create");
        return "redirect:/";
    }
}
