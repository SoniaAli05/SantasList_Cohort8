package qa.gilbertsonhoy.charlotte.springboot.database.santalist.mySpringBootDatabaseAppSantaList.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qa.gilbertsonhoy.charlotte.springboot.database.santalist.mySpringBootDatabaseAppSantaList.exception.ResourceNotFoundException;
import qa.gilbertsonhoy.charlotte.springboot.database.santalist.mySpringBootDatabaseAppSantaList.model.Model;
import qa.gilbertsonhoy.charlotte.springboot.database.santalist.mySpringBootDatabaseAppSantaList.repository.SantaListRepository;


@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	SantaListRepository myRepository;

	// Method to create a person
	@PostMapping("/person")
	public Model createPerson(@Valid @RequestBody Model mSDM) {
		return myRepository.save(mSDM);
	}

	// Method to get a person
	@GetMapping("/person/{id}")
	public Model getPerson(@PathVariable(value = "id") Long peopleID) {
		return myRepository.findById(peopleID)
				.orElseThrow(() -> new ResourceNotFoundException("Model", "id", peopleID));
	}
	
	
	// Method to get all people
	@GetMapping("/person")
	public List<Model> getAllPeople() {
		return myRepository.findAll();
	}

	// Method to update people
	@PutMapping("/person/{id}")
	public Model updatePeople(@PathVariable(value = "id") Long peopleID,
			@Valid @RequestBody Model peopleDetails) {

		Model mSDM = myRepository.findById(peopleID)
				.orElseThrow(() -> new ResourceNotFoundException("People", "id", peopleID));

		mSDM.setGift(peopleDetails.getGift());
		mSDM.setName(peopleDetails.getName());
		mSDM.setStatus(peopleDetails.getStatus());

		Model updateData = myRepository.save(mSDM);
		return updateData;
	}

	// Method to remove a people
	@DeleteMapping("/person/{id}")
	public ResponseEntity<?> deletePeople(@PathVariable(value = "id") Long peopleID) {
		Model mSDM = myRepository.findById(peopleID)
				.orElseThrow(() -> new ResourceNotFoundException("People", "id", peopleID));
		myRepository.delete(mSDM);
		return ResponseEntity.ok().build();
	}

	// Method to delete all people
	@DeleteMapping("/person")
	public ResponseEntity<?> deleteAllPeople() {
		myRepository.deleteAll();
		return ResponseEntity.ok().build();
	}
}
