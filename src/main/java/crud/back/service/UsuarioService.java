package crud.back.service;

import crud.back.model.Usuario;
import crud.back.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService
{
    @Autowired
    private UsuarioRepository usuarioRepository;

 /*   public Usuario saveUsuario (Usuario usuario)
    {
        if (usuario.getId() != null)
        {
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public Page<Usuario> getAllUsuarios(Integer page, Integer size, Boolean enablePagination)
    {
        return usuarioRepository.findAll(enablePagination ? PageRequest.of(page, size): Pageable.unpaged());
    }*/

    /*Listar todos los usuarios*/
    public List<Usuario> listUser()
    {
        return usuarioRepository.findAll();
    }
    /*Obtener un usuario por id*/

    public Usuario idUser(Long id)
    {
        return usuarioRepository.findById(id).orElse(null);
    }
    /*guardar usuario*/
    public Usuario saveUser(Usuario usuario)
    {
        return usuarioRepository.save(usuario);
    }
    /*Eliminar usuario*/
    public void deleteUser(Long id)
    {
        usuarioRepository.deleteById(id);
    }


}
