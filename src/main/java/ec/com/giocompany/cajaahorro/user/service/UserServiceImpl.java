package ec.com.giocompany.cajaahorro.user.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import ec.com.giocompany.cajaahorro.user.data.UserRepository;
import ec.com.giocompany.cajaahorro.user.model.pojo.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ec.com.giocompany.cajaahorro.user.model.pojo.User;
import ec.com.giocompany.cajaahorro.user.model.request.CreateUserRequest;

@Service
@Slf4j
public class UserServiceImpl implements ec.com.giocompany.cajaahorro.user.service.UserService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ObjectMapper objectMapper;


	/*@Override
	public List<User> getProducts(String name, String country, String description, Boolean visible) {

		if (StringUtils.hasLength(name) || StringUtils.hasLength(country) || StringUtils.hasLength(description)
				|| visible != null) {
			return repository.search(name, country, description, visible);
		}

		List<User> products = repository.getProducts();
		return products.isEmpty() ? null : products;
	}*/

	@Override
	public User buscarUsuario(String userId) {
		return repository.buscarUsuarioPorId(userId);
	}

	@Override
	public User autenticarUsuario(String userNom,String userPwd) {

		User usuario = repository.autenciarUsuario(userNom,userPwd);
		//User user = repository.autenciarUsuario(userNom,userPwd).orElseThrow(() -> new UsernameNotFoundException("Usuario no existe"));
        if (passwordEncoder.matches(userPwd, usuario.getUserPwd())) {
			return usuario;
		}

		return null;

	}

	/*@Override
	public Boolean removeProduct(String productId) {

		User product = repository.getById(Long.valueOf(productId));

		if (product != null) {
			repository.delete(product);
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}*/

	@Override
	public User createUser(CreateUserRequest request) {
		String hashedPassword = passwordEncoder.encode(request.getUserPwd());
		if (StringUtils.hasLength(request.getUserId().trim()) && StringUtils.hasLength(request.getUserNom().trim()) &&
				StringUtils.hasLength(hashedPassword) && request.getUserStatus() != null && request.getUserSuper() != null) {
			User user = User.builder().userId(request.getUserId()).userNom(request.getUserNom())
					.userPwd(hashedPassword).userStatus(request.getUserStatus()).userSuper(request.getUserSuper()).userMail(request.getUserMail()).
					userSuper(request.getUserSuper()).userCreDat(request.getUserCreDat()).build();
			return repository.save(user);
		} else {
			return null;
		}
	}

	/*@Override
	public User updateProduct(String productId, String request) {

		//PATCH se implementa en este caso mediante Merge Patch: https://datatracker.ietf.org/doc/html/rfc7386
		User product = repository.getById(Long.valueOf(productId));
		if (product != null) {
			try {
				JsonMergePatch jsonMergePatch = JsonMergePatch.fromJson(objectMapper.readTree(request));
				JsonNode target = jsonMergePatch.apply(objectMapper.readTree(objectMapper.writeValueAsString(product)));
				User patched = objectMapper.treeToValue(target, User.class);
				repository.save(patched);
				return patched;
			} catch (JsonProcessingException | JsonPatchException e) {
				log.error("Error updating product {}", productId, e);
                return null;
            }
        } else {
			return null;
		}
	}

	@Override
	public User updateProduct(String productId, UserDto updateRequest) {
		User product = repository.getById(Long.valueOf(productId));
		if (product != null) {
			product.update(updateRequest);
			repository.save(product);
			return product;
		} else {
			return null;
		}
	}*/

}
