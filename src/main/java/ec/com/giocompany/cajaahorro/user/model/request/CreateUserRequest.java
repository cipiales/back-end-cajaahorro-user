package ec.com.giocompany.cajaahorro.user.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
	private String userId;
	private String userNom;
	private String userPwd;
	private String userSuper;
	private String userMail;
	private String userStatus;
	private Timestamp userPasswordCaducityDate;
	private Timestamp userCreDat;
	private Timestamp userUpdDat;



}
