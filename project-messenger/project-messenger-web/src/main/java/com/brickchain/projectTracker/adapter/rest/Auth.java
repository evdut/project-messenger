package com.brickchain.projectTracker.adapter.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("/auth")
@ApplicationScoped
public class Auth {

	@PUT
	@Path("/signout")
    public void signOut(@Context HttpServletRequest httpServletRequest) throws ServletException {
		httpServletRequest.logout();
		httpServletRequest.getSession().invalidate();
    }
}
