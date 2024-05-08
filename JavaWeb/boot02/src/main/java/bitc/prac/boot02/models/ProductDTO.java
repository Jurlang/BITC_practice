package bitc.prac.boot02.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ProductDTO {
	@NotEmpty(message = "please input Name")
	private String name;
	@NotEmpty(message = "please input Brand")
	private String brand;
	@NotEmpty(message = "please input Category")
	private String category;
	@Min(0)
	private int price;

	@Size(min = 10, message = "Product Description Size > 10")
	@Size(max = 100, message = "Product Description Size < 100")
	private String description;

	private MultipartFile imageFile;
}
