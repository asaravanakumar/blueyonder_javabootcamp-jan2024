package com.labs.sboot.rest.controller;

import com.labs.sboot.rest.exception.GreetingsAppException;
import com.labs.sboot.rest.exception.NoGreetingsFoundException;
import com.labs.sboot.rest.model.Greeting;
import com.labs.sboot.rest.model.ResponseMessage;
import com.labs.sboot.rest.service.GreetingsService1;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/greetings1")
public class GreetingsController1 {

    private static Logger log = LoggerFactory.getLogger(GreetingsController1.class);

    @Autowired
    WebApplicationContext ctx;

    @Autowired
    GreetingsService1 service;

//    GreetingsService1 service = new GreetingsServiceObjImpl();

    // POST /greetings
//    @RequestMapping(path = "/greetings1", method = RequestMethod.POST)
//    @PostMapping(path = "/greetings1")
    @PostMapping(consumes = {"application/json", "application/xml"})
    public ResponseEntity<ResponseMessage> greetingWithPost(@RequestBody @Valid Greeting greeting) throws URISyntaxException, GreetingsAppException {  // BindingResult errors
        // Validation Approach #1: Custom Validation logic. Not Recommended
//        String valErrorMsg = null;
//        if(greeting.getType() == null || greeting.getType().isBlank()) {
//            valErrorMsg = "Type can't be blank";
//        }
//
//        if(greeting.getMessage() == null || greeting.getMessage().isBlank()) {
//            valErrorMsg = "Message can't be blank";
//        } else if(greeting.getMessage().length() > 20) {
//            valErrorMsg = "Message can't be more than 20 characters";
//        }

//        if(valErrorMsg != null ) {
//            log.error(valErrorMsg);
//            return ResponseEntity.badRequest().body(valErrorMsg);
//        }


        // Validation Approach #2: Validation API. Access Binding Result object for Error Handling.
        // WARNING: Don't Access Binding Result object for Approach #3
//        if(errors.hasErrors()) {
//            StringBuilder valErrorMsg = new StringBuilder("Validation Error!!!\n");
//
//            valErrorMsg.append(errors.getAllErrors().stream().map(err -> err.getDefaultMessage()).collect(Collectors.joining(",\n")));
//
//            return ResponseEntity.badRequest().body(valErrorMsg.toString());
//        }

        String id = String.valueOf(service.addGreeting(greeting));
        String msg = "Greetings created - " + id;
        log.info(msg);
        URI uri = new URI("http://localhost:8080/spring-rest-labs/greetings1/" + id);
        ResponseMessage response = new ResponseMessage("Success", msg);
        return ResponseEntity.created(uri).body(response);
    }

    // GET /greetings
//    @RequestMapping(path = "/greetings1", method = RequestMethod.GET)
//    @GetMapping(path = "/greetings1")
    @GetMapping
    public Collection<Greeting> greetingWithGetAll() {
        log.debug("Get All Greetings called");
        return service.getAllGreetings();
    }

    // GET /greetings/{id}
//    @RequestMapping(path = "/greetings1/{id}", method = RequestMethod.GET)
//    @GetMapping(path = "/greetings1/{id}")
    @GetMapping(path = "/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<Greeting> greetingWithGet(@PathVariable(name = "id", required = true) int id) throws GreetingsAppException, NoGreetingsFoundException {
        Greeting greeting = null;
//        try {
//            greeting = service.getGreeting(id).orElseThrow();
//        }catch(NoSuchElementException e) {
//            return ResponseEntity.internalServerError().body(greeting);
//        }
        greeting = service.getGreeting(id).get();

        return ResponseEntity.ok().body(greeting);

    }

    // PUT /greetings/{id}
//    @RequestMapping(path = "/greetings1/{id}", method = RequestMethod.PUT)
//    @PutMapping(path = "/greetings1/{id}")
    @PutMapping(path = "/{id}")
    public ResponseEntity<ResponseMessage> greetingsWithPut(@PathVariable(name = "id", required = true) int id, @RequestBody Greeting greeting) {
        ResponseMessage response =  service.updateGreeting(id, greeting) ? new ResponseMessage("Success", "Update Successfull!!!")  : new ResponseMessage("Failure", "Update Failed!!!");
        log.info(response.toString());
        return ResponseEntity.ok(response);
    }

    // DELETE /greetings/{id}
//    @RequestMapping(path = "/greetings1/{id}", method = RequestMethod.DELETE)
//    @DeleteMapping(path = "/greetings1/{id}")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ResponseMessage>  greetingsWithDelete(@PathVariable(name = "id", required = true) int id) {
        ResponseMessage response = service.deleteGreeting(id) ? new ResponseMessage("Success", "Delete Successfull!!!")  : new ResponseMessage("Failure", "Delete Failed!!!");
        log.info(response.toString());
        return ResponseEntity.ok(response);
    }

    @RequestMapping(path = "/beans")
    public String getBeans() {
        return Arrays.stream(ctx.getBeanDefinitionNames()).collect(Collectors.joining(", "));
    }

    @RequestMapping(path = "/beans/count")
    public String getBeansCount() {
        return String.valueOf(ctx.getBeanDefinitionCount());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ResponseMessage> handleNoSuchElementException(NoSuchElementException e) {
        String msg = "No matching greetings found";
        log.error(msg, e);
        ResponseMessage response = new ResponseMessage("Failure", msg);
        return ResponseEntity.internalServerError().body(response);
    }

    // Validation Approach #3: Validation API. Exception Handler for MethodArgumentNotValidException. Recommended.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseMessage> handleValidationException(MethodArgumentNotValidException e){
            StringBuilder valErrorMsg = new StringBuilder("Validation Error!!!\n");
            valErrorMsg.append(e.getBindingResult().getAllErrors().stream().map(err -> err.getDefaultMessage()).collect(Collectors.joining(",\n")));
            ResponseMessage response = new ResponseMessage("Failure", valErrorMsg.toString());
            return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(NoGreetingsFoundException.class)
    public ResponseEntity<ResponseMessage> handleNoGreetingsFoundException(Exception e) {
        String msg = "ERROR: " + e.getMessage();
        ResponseMessage response = new ResponseMessage("Failure", msg);
        return ResponseEntity.internalServerError().body(response);
    }

    @ExceptionHandler(GreetingsAppException.class)
    public ResponseEntity<ResponseMessage> handleGreetingsAppException(Exception e) {
        String msg = "ERROR: " + e.getMessage();
        ResponseMessage response = new ResponseMessage("Failure", msg);
        return ResponseEntity.internalServerError().body(response);
    }
}
