package ec.com.giocompany.cajaahorro.user.model.pojo;

import jakarta.persistence.Column;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto {
	
	/*private String name;
	private String country;
	private String description;
	private Boolean visible;*/

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
