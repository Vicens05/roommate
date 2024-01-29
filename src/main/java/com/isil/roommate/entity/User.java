package com.isil.roommate.entity;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Transient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.isil.roommate.entity.UserRole;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Representa a un usuario en la aplicación.
 */
@Entity
@Data
@RequiredArgsConstructor
public class User implements UserDetails {
    
    /**
     * Identificador único para el usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de usuario del usuario. Debe ser único.
     */
    @NotNull
    @Column(unique = true)
    @Size(min = 8, max = 8, message = "El nombre usuario es obligatorio, solo 8 caracteres numéricos")
    private String username;

    /**
     * Campo transitorio para la contraseña.
     */
    @NotNull
    @Transient
    private String password;

    /**
     * Rol del usuario.
     */
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserRole role;

    /**
     * Devuelve las autoridades del usuario, en este caso, el rol con el prefijo "ROLE_".
     *
     * @return Colección de GrantedAuthority que representa los roles del usuario.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + this.role.name()));
    }

    /**
     * Devuelve si la cuenta del usuario no ha caducado.
     *
     * @return Siempre devuelve true.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Devuelve si la cuenta del usuario no está bloqueada.
     *
     * @return Siempre devuelve true.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Devuelve si las credenciales del usuario (contraseña) no han caducado.
     *
     * @return Siempre devuelve true.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Devuelve si el usuario está habilitado.
     *
     * @return Siempre devuelve true.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
