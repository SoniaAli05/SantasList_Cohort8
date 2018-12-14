package qa.gilbertsonhoy.charlotte.springboot.database.santalist.mySpringBootDatabaseAppSantaList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qa.gilbertsonhoy.charlotte.springboot.database.santalist.mySpringBootDatabaseAppSantaList.model.Model;

@Repository
public interface SantaListRepository extends JpaRepository<Model, Long> {

	/*List<Model> findByName(String Name);
	List<Model> findByStatus(String status);*/

}