package se.lexicon.exceptions.workshop;

import java.io.Console;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class Main {

	public static void main(String[] args) {

		List <String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        //System.out.println(" Male First Name Size: " + maleFirstNames.size());
        //System.out.println("---------------------------");


        /*System.out.println(" Male First Name Size: " + maleFirstNames.size());
        System.out.println("---------------------------");*/

        List <String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();
        //System.out.println("Female First Name Size: "+femaleFirstNames.size());
        //System.out.println("---------------------------");



        List<String> lastNames = null;
        try {
            lastNames = CSVReader_Writer.getLastNames();
        }catch (IOException e) {
            System.out.println(e);
        }

        NameService nameService = new NameService(maleFirstNames, femaleFirstNames,lastNames);


        Person test = nameService.getNewRandomPerson();
        System.out.println(test);

        //MJ
        try{
                nameService.addLastName("Ali");
        }catch (DuplicateNameException e){
                System.out.println("LastName already exists");
        }

            try{
                    nameService.addFemaleFirstName("Luna");
            }catch (DuplicateNameException e){
                    System.out.println("Female firstname already exists");
            }

            try{
                    nameService.addMaleFirstName("Love");
            }catch (DuplicateNameException e){
                    System.out.println("Male firstName already exists");
            }

	}

}
