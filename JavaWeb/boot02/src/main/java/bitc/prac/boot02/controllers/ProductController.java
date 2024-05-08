package bitc.prac.boot02.controllers;

import bitc.prac.boot02.models.Product;
import bitc.prac.boot02.models.ProductDTO;
import bitc.prac.boot02.services.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository repo;

	// 아무 주소가 없거나, 기본 주소만 들어왔을 경우 2개의 경우일땐 {} 로 작성
	@GetMapping({"", "/"})
	public String showProductList(Model model){

		List<Product> pList = repo.findAll();
		model.addAttribute("products", pList);

		return "products/index";
	}

	@GetMapping("create")
	public String showCreateForm(Model model){

		ProductDTO productDto = new ProductDTO();
		model.addAttribute("productDto", productDto);

		return "/products/createProduct";
	}

	@PostMapping("create")
	public String processCreateForm(@Valid @ModelAttribute("productDto") ProductDTO productDto, BindingResult bindingResult){

		// 이미지가 없으면 에러 ( 원래 dto 에 사진 파일은 없기 때문에 에러를 추가로 수정 )
		if(productDto.getImageFile().isEmpty()){
			bindingResult.addError(new FieldError("productDto", "imageFile", "Image file is required"));
			return "/products/createProduct";
		}

		// Valid 에 의해 발견되는 에러
		if(bindingResult.hasErrors()){
			return "/products/createProduct";
		}

		MultipartFile image = productDto.getImageFile();
		Date createDate = new Date();
		String storeFileName = createDate.getTime() + "_" + image.getOriginalFilename();

		try{
			String uploadDir = "public/images/";
			Path uploadPath = Paths.get(uploadDir);

			if (!Files.exists(uploadPath)) {
				Files.createDirectory(uploadPath);
			}

			try (InputStream inputStream = image.getInputStream()){
				Files.copy(inputStream, Paths.get(uploadDir + storeFileName), StandardCopyOption.REPLACE_EXISTING);
			}

		}catch(Exception ex){
			System.out.println("Error: " + ex.getMessage());
		}

		Product product = new Product();
		product.setName(productDto.getName());
		product.setBrand(productDto.getBrand());
		product.setCategory(productDto.getCategory());
		product.setPrice(productDto.getPrice());
		product.setDescription(productDto.getDescription());
		product.setImageFileName(storeFileName);

		repo.save(product);

		return "redirect:/products";
	}

	@GetMapping("edit")
	public String showEditForm(Model model, @RequestParam int id){
		try {

			Product product = repo.findById(id).get();
			model.addAttribute("product", product);

			ProductDTO productDto = new ProductDTO();
			productDto.setName(product.getName());
			productDto.setBrand(product.getBrand());
			productDto.setCategory(product.getCategory());
			productDto.setPrice(product.getPrice());
			productDto.setDescription(product.getDescription());

			model.addAttribute("productDto", productDto);

		}catch(Exception ex){
			System.err.println("Error : " + ex.getMessage());
		}

		return "/products/editProduct";
	}
}
