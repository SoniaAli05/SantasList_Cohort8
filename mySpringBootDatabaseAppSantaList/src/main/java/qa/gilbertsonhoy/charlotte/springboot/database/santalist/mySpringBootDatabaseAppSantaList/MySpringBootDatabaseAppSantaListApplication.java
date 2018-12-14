package qa.gilbertsonhoy.charlotte.springboot.database.santalist.mySpringBootDatabaseAppSantaList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MySpringBootDatabaseAppSantaListApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootDatabaseAppSantaListApplication.class, args);
	}

}

