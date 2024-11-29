package pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostPetStoreUser{
	private String firstName;
	private String lastName;
	private String password;
	private int userStatus;
	private String phone;
	private int id;
	private String email;
	private String username;
}