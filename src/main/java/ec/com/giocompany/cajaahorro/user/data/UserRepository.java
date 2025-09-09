package ec.com.giocompany.cajaahorro.user.data;

import ec.com.giocompany.cajaahorro.user.data.utils.SearchCriteria;
import ec.com.giocompany.cajaahorro.user.data.utils.SearchOperation;
import ec.com.giocompany.cajaahorro.user.data.utils.SearchStatement;
import ec.com.giocompany.cajaahorro.user.model.pojo.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
@Repository
@RequiredArgsConstructor


@RestController

@Slf4j
public class UserRepository {

    private final UserJpaRepository repository;

    /*public List<User> getProducts() {
        return repository.findAll();
    }
*/
    public User getById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public User save(User product) {
        return repository.save(product);
    }

    /*

    public void delete(User product) {
        repository.delete(product);
    }
*/
    public User buscarUsuarioPorId(String  userId) {
        SearchCriteria<User> spec = new SearchCriteria<>();
        if (StringUtils.isNotBlank(userId)) {
            spec.add(new SearchStatement("userId", userId, SearchOperation.MATCH));
        }

        List<User> resultados = repository.findAll(spec);
        log.info("resultados:", resultados);

        if (resultados == null) {
            return null;  // No encontrado
        } else if (resultados.size() != 1) {
            return null; // No encontrado
        } else {
            return resultados.get(0);  // Devuelve el encontrado
        }
    }


    public User autenciarUsuario(String  userNom,String userPwd) {
        SearchCriteria<User> spec = new SearchCriteria<>();
        if (StringUtils.isNotBlank(userNom)) {
            spec.add(new SearchStatement("userNom", userNom, SearchOperation.EQUAL));
        }
        /*if (StringUtils.isNotBlank(userPwd)) {
            spec.add(new SearchStatement("userPwd", userPwd, SearchOperation.EQUAL));
        }*/

        List<User> resultados = repository.findAll(spec);
        log.info("resultados Usuarios:", resultados);

        if (resultados == null) {
            return null;  // No encontrado
        } else if (resultados.size() != 1) {
            return null; // No encontrado
        } else {
            return resultados.get(0);  // Devuelve el encontrado
        }
    }






}
