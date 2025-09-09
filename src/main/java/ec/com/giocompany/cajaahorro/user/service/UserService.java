package ec.com.giocompany.cajaahorro.user.service;

import java.util.List;

import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import ec.com.giocompany.cajaahorro.user.model.pojo.User;
import ec.com.giocompany.cajaahorro.user.model.pojo.UserDto;
import ec.com.giocompany.cajaahorro.user.model.request.CreateUserRequest;

public interface UserService {
	
	//List<User> getProducts(String name, String country, String description, Boolean visible);
	
	User buscarUsuario(String userId);

	User autenticarUsuario(String userNom,String userPwd);
	//Boolean removeProduct(String productId);
	
	User createUser(CreateUserRequest request);

	//User updateProduct(String productId, String updateRequest);

	//User updateProduct(String productId, UserDto updateRequest);

}
