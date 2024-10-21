// package Project.Backend.entity;

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
// @Table(name = "VocabularyList")
// @SequenceGenerator(
// 	allocationSize = 1,
// 	initialValue = 0,
// 	name = "VocabularyListSeq",
// 	sequenceName = "VocabularyListSeq"
// )
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Getter
// @Setter
// public class VocabularyList {
// 	@Id
// 	@GeneratedValue (
// 			generator = "VocabularyListSeq",
// 			strategy = GenerationType.SEQUENCE
// 			)
// 	Long vocabularyListId;
	
// 	@ManyToOne(fetch = FetchType.EAGER)
// 	@JoinColumn(name = "userId")
// 	User user;
// 	String wordEN;
// 	String wordKO;
// 	Boolean bookmarkState;
// }
