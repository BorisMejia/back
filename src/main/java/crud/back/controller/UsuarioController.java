package crud.back.controller;

import crud.back.model.Usuario;
import crud.back.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UsuarioController
{
    @Autowired
    private UsuarioService usuarioService;

    /*Consultar todos los usuarios*/
    @GetMapping
    public ResponseEntity<List<Usuario>> consultarUsuarios()
    {
        try {
            List<Usuario>consultarAllUsuarios = this.usuarioService.listUser();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(consultarAllUsuarios);
        }catch (Exception errpr)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    /*Crear un usuario*/
    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario)
    {
        try {
            Usuario respuestaServicio = this.usuarioService.saveUser(usuario);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(respuestaServicio);
        }catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    /*Buscar usuario por id*/
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioId(@PathVariable Long id)
    {
        try {
            Usuario respuestaServicio = this.usuarioService.idUser(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(respuestaServicio);
        }catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    /*Eliminar un usuario*/

    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id)
    {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioService.idUser(id));
        }catch (Exception error)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}
