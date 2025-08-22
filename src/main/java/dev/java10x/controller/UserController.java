package dev.java10x.controller;

import dev.java10x.domain.Users;
import dev.java10x.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    public Response findAllUsers(@QueryParam("page") @DefaultValue("0") Integer page,
                                 @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        var users = userService.findAllUsers(page, pageSize);
        return Response.ok(users).build();
    }

    @GET
    @Path("/{id}")
    public Response findUserById(@PathParam("id") UUID userId) {
        var users = userService.findUserById(userId);
        return Response.ok(users).build();
    }

    @POST
    @Transactional //obrigatorio bloco transacional, menos no GET
    public Response CreateUsers(Users users) {
        return Response.ok(userService.createUser(users)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateUser(@PathParam("id") UUID userId, Users users) {
        var user = userService.updateUser(userId, users);
        return Response.ok(user).build();
    }
}
