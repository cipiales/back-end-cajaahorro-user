package ec.com.giocompany.cajaahorro.user.model.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.sql.Timestamp;

@Entity
@Table(name = "gscatuser")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
	@Id
	@Column(name="USERID", nullable=false)
	private String userId;
	@Column(name="USERNOM", nullable=false)
	private String userNom;
	@Column(name="USERPWD", nullable=false)
	private String userPwd;
	@Column(name="USERSUPER", nullable=false)
	private String userSuper;
	@Column(name="USERMAIL", nullable=false)
	private String userMail;
	@Column(name="USERSTATUS", nullable=false)
	private String userStatus;
	@Column(name="USERPASSWORDCADUCITYDATE", nullable=true)
	private Timestamp userPasswordCaducityDate;
	@Column(name="USERCREDAT", nullable=false)
	private Timestamp userCreDat;
	@Column(name="USERUPDDAT", nullable=true)
	private Timestamp userUpdDat;


	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "visible")
	private Boolean visible;

	public void update(ec.com.giocompany.cajaahorro.user.model.pojo.UserDto productDto) {
		this.name = productDto.getName();
		this.country = productDto.getCountry();
		this.description = productDto.getDescription();
		this.visible = productDto.getVisible();
	}*/

	public void update(ec.com.giocompany.cajaahorro.user.model.pojo.UserDto userDto) {
		this.userNom = userDto.getUserNom();
		this.userPwd = userDto.getUserPwd();
		this.userSuper = userDto.getUserSuper();
		this.userMail = userDto.getUserMail();
		this.userStatus = userDto.getUserStatus();
		this.userPasswordCaducityDate = userDto.getUserPasswordCaducityDate();
		this.userCreDat = userDto.getUserCreDat();
		this.userUpdDat = userDto.getUserUpdDat();
	}

}
