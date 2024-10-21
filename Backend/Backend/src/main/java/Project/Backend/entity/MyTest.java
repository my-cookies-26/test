// package Project.Backend.entity;

// import java.util.List;
// import java.util.Map;

// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.SequenceGenerator;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Entity
// @Table(name = "MyTest")
// @SequenceGenerator(
// 	allocationSize = 1,
// 	initialValue = 0,
// 	name = "MyTestSeq",
// 	sequenceName = "MyTestSeq"
// )
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Getter
// @Setter
// public class MyTest {
// 	@Id
// 	@GeneratedValue (
// 			generator = "MyTestSeq",
// 			strategy = GenerationType.SEQUENCE
// 			)
// 	Long myTestId;
	
// 	@ManyToOne(fetch = FetchType.EAGER)
// 	@JoinColumn(name = "userId")
// 	User user;
// 	Integer testCount;
	
// 	@ManyToOne(fetch = FetchType.EAGER)
// 	@JoinColumn(name = "questionId")
// 	QuestionList questionList;
	
// 	String testType;
	
	
	
// }
