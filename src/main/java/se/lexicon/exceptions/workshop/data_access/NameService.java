package se.lexicon.exceptions.workshop.data_access;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import se.lexicon.exceptions.workshop.DuplicateNameException;
import se.lexicon.exceptions.workshop.domain.Gender;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class NameService {
	

	    private List<String>maleFirstNames;
	    private List<String>femaleFirstNames;
	    private List<String>lastNames;
	    private static Random random = new Random();

	    //should be no nulls
	    public NameService(List<String> maleFirstNames, List<String> femaleFirstNames, List<String> lastNames) {

	        this.maleFirstNames = maleFirstNames;
	        this.femaleFirstNames = femaleFirstNames;
	        this.lastNames = lastNames;
	    }

	    public Person getNewRandomPerson(){
	        Gender gender = getRandomGender();
	        Person person = null;
	        switch (gender){
	            case MALE:
	                person = new Person(getRandomMaleFirstName(),getRandomLastName(),gender);
	                break;
	            case FEMALE:
	                person = new Person(getRandomFemaleFirstName(),getRandomLastName(),gender);
	                break;
	        }
	        return person;
	    }


	    public String getRandomFemaleFirstName(){
	        return femaleFirstNames.get(random.nextInt(femaleFirstNames.size()));
	    }

	    public String getRandomMaleFirstName(){
	        return maleFirstNames.get(random.nextInt(maleFirstNames.size()));
	    }

	    public String getRandomLastName(){
	        return lastNames.get(random.nextInt(lastNames.size()));
	    }

	    public Gender getRandomGender(){
	        return random.nextInt(100) > 50 ? Gender.FEMALE : Gender.MALE;
	    }


	    /**
	     * Here you need to check if List<String> femaleFirstNames already contains the name
	     * If name already exists throw a new custom exception you will have to create called
	     * DuplicateNameException.
	     * @param name
	     */
	    public void addFemaleFirstName(String name) throws DuplicateNameException {

			// MJ-> if (femaleFirstNames.contains(name)) throw new DuplicateNameException("Sorry! could not add " + name +" already exists in list!");

			Optional<String> nameToAdd = femaleFirstNames.stream()
										.filter(n->n.equalsIgnoreCase(name))
										.findFirst();

		if(!nameToAdd.isPresent()){
			femaleFirstNames.add(name);
			CSVReader_Writer.saveFemaleNames(femaleFirstNames);
			}else throw new DuplicateNameException("Name already exists", 1, name);
		}

	    /**
	     * Here you need to check if List<String> maleFirstNames already contains the name
	     * If name already exists throw a new custom exception you will have to create called
	     * DuplicateNameException.
	     * @param name
	     */
	    public void addMaleFirstName(String name)throws DuplicateNameException {

			// MJ ->
			if (maleFirstNames.contains(name)) throw new DuplicateNameException("Sorry! could not add " + name +" already exists in list!");
			/*Optional<String> nameToAdd = maleFirstNames.stream()
					.filter(n -> n.equalsIgnoreCase(name))
					.findFirst();

			if (!nameToAdd.isPresent()) {
				maleFirstNames.add(name);
				CSVReader_Writer.saveMaleNames(maleFirstNames);
			} else throw new DuplicateNameException("Name already exists", 2, name);
*/
		}
	    /**
	     * Here you need to check if List<String> lastNames already contains the name
	     * If name already exists throw a new custom exception you will have to create called
	     * DuplicateNameException.
	     * @param lastName
	     */
	    public void addLastName(String lastName) throws DuplicateNameException{

			// MJ -> if (lastNames.contains(lastName)) throw new DuplicateNameException("Sorry! could not add " + lastName +" already exists in list!");

			Optional<String> nameToAdd = lastNames.stream()
					.filter(n -> n.equalsIgnoreCase(lastName))
					.findFirst();

			if (!nameToAdd.isPresent()) {
				lastNames.add(lastName);
				CSVReader_Writer.saveLastNames(lastNames);
			} else throw new DuplicateNameException("LastName already exists", 3, lastName);
		}
	
}
