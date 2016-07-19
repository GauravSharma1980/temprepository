package org.example.ws.web.api;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.ws.model.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingController  {

	private static BigInteger nextId;
	private static String text;
	
	 protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static Map myGreetings;

	
	static{
		Greeting greeting1 = new Greeting();
		greeting1.setId(nextId);
		greeting1.setText("Hello World");
		
		Greeting greeting2 = new Greeting();
		greeting1.setId(nextId.add(BigInteger.ONE));
		greeting1.setText("Ola World");
		
		myGreetings.put(greeting1.getId(),greeting1);
		myGreetings.put(greeting2.getId(),greeting2);
		
	}

	
	
	@RequestMapping(
            value = "/api/greetings",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Greeting>> getGreetings() {
        logger.info("> getGreetings");

        Collection<Greeting> greetings = null;

        logger.info("< getGreetings");
        return new ResponseEntity<Collection<Greeting>>(greetings,
                HttpStatus.OK);
    }

	
	@RequestMapping(
            value = "/api/addgreetings",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Greeting>> postGreetings() {
        logger.info("> postGreetings");

        Collection<Greeting> greetings = null;

        logger.info("< postGreetings");
        return new ResponseEntity<Collection<Greeting>>(greetings,
                HttpStatus.OK);
    }
	
	
	
	public Greeting save(Greeting greeting)
	{
		if(null == myGreetings )
		{ 
			myGreetings	 = new HashMap<BigInteger,Greeting>();
			nextId.add(BigInteger.ONE);
			greeting.setId(nextId);
			myGreetings.put(greeting.getId(),greeting);
		}
		
	    return greeting;	
	}

	
	
}
