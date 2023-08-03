package br.com.controller;


import java.util.List;

import br.com.dto.LineDTO;
import br.com.service.LineService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/liners")
public class LineController {
    
    @Inject
    LineService lineService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LineDTO> findAllLiners(){
        return lineService.findAllLines();
    }

    @POST
    @Transactional
    public Response saveLine(LineDTO lineDTO){
        try {
            lineService.createNewLine(lineDTO);
            return Response.ok().build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response changeLine(@PathParam("id") Long id, LineDTO lineDTO){
        try {
            lineService.changeLine(id, lineDTO);
            return Response.accepted().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteLine(@PathParam("id") Long id){
        try {
            lineService.deleteLine(id);
            return Response.accepted().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
