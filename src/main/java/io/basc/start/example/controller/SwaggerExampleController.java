package io.basc.start.example.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import io.basc.framework.http.MediaType;
import io.basc.framework.mvc.annotation.Controller;
import io.basc.framework.web.message.annotation.RequestBody;

@Path("/swagger")
@Controller
public class SwaggerExampleController {
	@Path("form-params")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public TestRequest test(@RequestBody TestRequest request) {
		return request;
	}
}
