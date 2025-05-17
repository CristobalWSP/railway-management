package com.management.managementVL101.Service;

import com.management.managementVL101.Model.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(Long id);
    Usuario createUsuario(Usuario usuario);
    Usuario modificarUsuario(Long id, Usuario usuario);
}
