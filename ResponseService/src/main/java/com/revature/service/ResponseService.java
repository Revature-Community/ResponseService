package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Response;
import com.revature.repositories.ResponseRepository;

@Service
@Transactional
public class ResponseService {
    @Autowired
    private ResponseRepository rrepo;

    public List<Response> getResponsesByPostId(int postId) {
        return rrepo.getResponsesByPostId(postId); 
    }

    public Response submitResponse(Response response) {
        rrepo.save(response);
        return response; 
    }

    public Response updateResponse(Response response) { 
        Response updatedr = rrepo.findById(response.getId()).get();
        updatedr.setContent(response.getContent());
        return rrepo.save(updatedr);
    }
    public void deleteResponse(Integer id) {
        Response deleted = rrepo.findById(id).get();
        rrepo.delete(deleted);
    }
    
    public Response getResponseById(Integer id) {
    	return rrepo.findById(id).get();
    }
}