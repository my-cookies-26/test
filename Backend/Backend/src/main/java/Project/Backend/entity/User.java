package Project.Backend.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UserTable")
@SequenceGenerator(
	allocationSize = 1,
	initialValue = 0,
	name = "UserSeq",
	sequenceName = "UserSeq"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(
		generator = "UserSeq",
		strategy =  GenerationType.SEQUENCE
	)
	Long id;
	String name;
	String pwd;
	
	@ElementCollection
	List<String> auths = new ArrayList<String>();
	
	@Transient
	Map<String, Object> attributes = new HashMap<String, Object>();
	
	public User addAuth(String auth) {
		auths.add(auth);
		return this;
	}
	

	
}

//@Entity
//@Table(name = "User")
//@SequenceGenerator(
//	allocationSize = 1,
//	initialValue = 0,
//	name = "UserSeq",
//	sequenceName = "UserSeq"
//)
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//public class User {
//	@Id
//	@GeneratedValue (
//			generator = "UserSeq",
//			strategy = GenerationType.SEQUENCE
//			)
//	Long userId;
//	String email;
//	String pw;
//	String nickname;
//	LocalDate birthdate;
//	Integer exp;
//	Integer point;
//	Integer grade;
//	
//	@OneToMany(mappedBy = "user")
//	Inventory inventory;
//	
//	@OneToMany(mappedBy = "myQuest")
//	MyQuest myQuest;
//
//	@OneToMany(mappedBy = "vocabularyList")
//	VocabularyList vocabularyList;
//	
//}
