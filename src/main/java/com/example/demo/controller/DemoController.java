package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DemoUser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @author E5405774 API URL http://localhost:8085/api/v1/demousers
 */
@RestController
@RequestMapping("/api/v1")
@Api(tags = { "Demo User System" } , description = "Operations pertaining to demo user in Demo User System")
//@SwaggerDefinition(tags = { @Tag(name = "Demo User System", description = "Operations pertaining to demo user in Demo User System") })
public class DemoController {
	private static List<DemoUser> demoUsers = new ArrayList<DemoUser>();

	static {
		demoUsers.add(new DemoUser("Sailesh", "Kushwaha", 28, new Date()));
		demoUsers.add(new DemoUser("Brijesh", "Kushwaha", 28, new Date()));
		demoUsers.add(new DemoUser("Neeraj", "Kushwaha", 28, new Date()));
		demoUsers.add(new DemoUser("Ravi", "Kushwaha", 28, new Date()));
	}

	@RequestMapping(value = "/demousers", method = RequestMethod.GET)
	@ApiOperation(value = "Find all demo users", notes = "Method to retrieve all demo users")
	public List<DemoUser> getDemoUsers() {
		return demoUsers;
	}

	@RequestMapping(value = "/demousers", method = RequestMethod.POST)
	@ApiOperation(value = "Add a demouser", notes = "Method to add demo user")
	public DemoUser addDemoUser(
			@ApiParam(value = "DemoUser object store in static list", required = true) @Valid @RequestBody DemoUser demoUser) {
		demoUsers.add(demoUser);
		return demoUser;
	}

	@RequestMapping(value = "/demousers/{demoUserName}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete a demouser", notes = "Method to delete demo user")
	public void deleteDemoUser(
			@ApiParam(value = "demoUserName to be delete from static list", required = true) @PathVariable String demoUserName) {
		demoUsers.forEach(x -> {
			if (x.getFirstName().equals(demoUserName)) {
				demoUsers.remove(x);
			}
		});
	}

	@RequestMapping(value = "/demousers/{demoUserName}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update a demouser", notes = "Method to update demo user")
	public void updateDemoUser(
			@ApiParam(value = "DemoUser object store in static list", required = true) @Valid @RequestBody DemoUser demoUser,
			@ApiParam(value = "demoUserName to be updated in static list", required = true) @PathVariable String demoUserName) {
		demoUsers.forEach(x -> {
			if (x.getFirstName().equals(demoUserName)) {
				DemoUser demouser1 = x;
				demouser1.setAge(demoUser.getAge());
				demouser1.setDob(demoUser.getDob());
				demouser1.setLastName(demoUser.getLastName());
				demouser1.setFirstName(x.getFirstName());
			}
		});
	}
}
