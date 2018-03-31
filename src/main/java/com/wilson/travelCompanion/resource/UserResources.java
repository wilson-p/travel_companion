package com.wilson.travelCompanion.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wilson.travelCompanion.model.User;
import com.wilson.travelCompanion.services.UserService;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResources {
	
	UserService userService = new UserService();
	
	@GET
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GET
	@Path("/{userId}")
	public User getUser(@PathParam("userId") int userId){
		return userService.getUser(userId);
	}
	
	@POST
	public User addUser(User user){
		return userService.addUser(user);
	}
	
	@PUT
	@Path("/{userId}")
	public User updateUser(@PathParam("userId") int userId, User user){
		//user.setUserId(userId);
		return userService.updateUser(userId, user);
	}
	
	@DELETE
	@Path("/{userId}")
	public void deleteUser(@PathParam("userId") int userId){
		userService.removeUser(userId);
	}
}
