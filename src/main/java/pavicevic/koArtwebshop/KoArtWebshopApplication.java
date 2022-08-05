package pavicevic.koArtwebshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pavicevic.koArtwebshop.entity.UserEntity;
import pavicevic.koArtwebshop.entity.ProductEntity;
import pavicevic.koArtwebshop.repository.UserEntityRepository;
import pavicevic.koArtwebshop.repository.ProductEntityRepository;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class KoArtWebshopApplication {


	@Autowired
	private ProductEntityRepository productEntityRepository;

	public static void main(String[] args) {
		SpringApplication.run(KoArtWebshopApplication.class, args);
	}


	@EventListener(ApplicationReadyEvent.class)
	public void testRepository() {
		ProductEntity p = new ProductEntity();
		UserEntity u= new UserEntity();

		u.setId(1);

//		u.setFirstName("Lik");
//		u.setLastName("Likovic");
//		u.setMobile("067xxxxxx");
//		u.setEmail("blabla@gmail.com");
		p.setAvailable(true);
		p.setUserEntity(u);
		p.setType_(1);
		p.setPrice(BigDecimal.valueOf(100));
		p.setDiscount(0.7);
		p.setQuantity(1);
		p.setCreatedAt(new Date());
		productEntityRepository.save(p);


	}
}
