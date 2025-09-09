package ec.com.giocompany.cajaahorro.user.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ec.com.giocompany.cajaahorro.user.model.pojo.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

interface UserJpaRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

	/*List<User> findByName(String name);

	List<User> findByCountry(String country);

	List<User> findByVisible(Boolean visible);

	List<User> findByNameAndCountry(String name, String country);*/

}
