package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Posts;
import com.revature.models.Response;
import com.revature.service.ResponseService;

@CrossOrigin("*")
@RestController
@RequestMapping("/responses")
public class ResponseController {

    @Autowired
    private ResponseService rservice; 


    @GetMapping("/responses/{postId}")
    public ResponseEntity<List<Response>> getresponsesbypostid(@PathVariable("postId") int postId) { 
        List<Response> rs = rservice.getResponsesByPostId(postId);
        return new ResponseEntity<List<Response>>(rs, HttpStatus.OK); 
    }

    @PostMapping("/submit-response")
    public ResponseEntity<Response> save(@RequestBody Response response) throws IOException {

        Response r = new Response(); 
        
        r.setContent(response.getContent());
        System.out.println(response.getContent());
        r.setPostId(response.getPostId());
        r.setUserId(response.getUserId());
        System.out.println(r);
        
        Response responseObject = rservice.submitResponse(response);
        return new ResponseEntity<Response>(responseObject, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Response> put(@RequestBody Response response) {
        Response updated = rservice.updateResponse(response);
        System.out.println("test" + response);
        return new ResponseEntity<Response>(updated, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") Integer id) {
        rservice.deleteResponse(id);
        return new ResponseEntity<Response>(HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable("id") Integer id) {
    	Response response = rservice.getResponseById(id);
    	return new ResponseEntity<Response> (response, HttpStatus.OK);
    }
    
}
