package bitc.prac.boot02.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String brand;
	private String category;
	private int price;

	@Column(columnDefinition = "TEXT")
	private String description;

	@CreationTimestamp
	private Date createAt;

	private String imageFileName;
}
