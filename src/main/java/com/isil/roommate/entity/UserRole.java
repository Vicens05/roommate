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

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// TODO(nzv): should this class be here? I mean, it's not an entity

/**
 * Enumeración que representa los roles del usuario.
 */
@RequiredArgsConstructor
@Getter 
public enum UserRole {
    ADMIN("Administrator"),
    RECEPCIONISTA("Recepcionista");

    private final String displayValue;
}
