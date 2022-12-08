package se.lexicon.exceptions.workshop;

import java.io.IOException;
import java.util.List;

import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class Main {

	public static void main(String[] args) {
		
		List <String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        System.out.println(maleFirstNames.size());

        List <String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();

        try {
            List<String> lastNames = CSVReader_Writer.getLastNames();
        }catch (IOException e) {
            System.out.println(e);
        }

        NameService nameService = new NameService(maleFirstNames, femaleFirstNames,lastNames);


        Person test = nameService.getNewRandomPerson();
        System.out.println(test);

	}

}
