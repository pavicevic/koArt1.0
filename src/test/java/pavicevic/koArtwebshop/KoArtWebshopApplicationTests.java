package pavicevic.koArtwebshop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pavicevic.koArtwebshop.repository.UserRepository;

@SpringBootTest(classes = KoArtWebshopApplication.class)
@Slf4j
public class KoArtWebshopApplicationTests {


	@Autowired
    UserRepository userRepository;

	@Test


	public void UserEntityRepository() {

		log.info(userRepository.findByName("Marjan").toString());



	}

//	@Test
//	void contextLoads() {
//	}

}
