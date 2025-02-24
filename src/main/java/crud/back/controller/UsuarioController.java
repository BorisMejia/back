package crud.back.controller;

import crud.back.model.Usuario;
import crud.back.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController
{
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("users")
    List<Usuario> all()
    {
        return usuarioService.listUser();
    }

}
