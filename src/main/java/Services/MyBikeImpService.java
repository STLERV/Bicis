package Services;
import eetac.*;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;

import io.swagger.annotations.ApiResponses;

import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;

import javax.ws.rs.core.GenericEntity;

import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Api (value = "/bicis", description = "Servicio de bicis")
@Path("/bicis")


public class MyBikeImpService {

    final static Logger log = Logger.getLogger(MyBikeImpService.class.getName());
    private MyBike mb;
    public MyBikeImpService(){

        this.mb = MyBikeImpl.getInstance();
    }
       ///////////////////////////////////////////////

    @GET

    @ApiOperation(value = " Numero de tricilos de una estación")

    @ApiResponses(value = {
            @ApiResponse( code = 201, message = "todo bien"),
            @ApiResponse( code =404, message = "la estacion no existe")
                })
            @Path("/{listabicis}")

    @Produces(MediaType.APPLICATION_JSON)
    public Response numBike(@PathParam("idStation") String idStation) throws StationException {  //->Te inventas una respuesta llamada así, como es un get no pide nada
        try {

            int numbikes;
            numbikes = mb.numBikes(idStation);
            return Response.status(201).entity(numbikes).build(); //-> haces un build con la respuesta y la lista
        } catch (StationException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }


         @GET
         @ApiOperation(value = "Lista de tricilos de una estación")

         @ApiResponses(value = {
                 @ApiResponse( code = 201, message = "todo bien"),
                 @ApiResponse( code =404, message = "la estacion no existe")
         })
         @Path("/{listaBikes}")

         @Produces(MediaType.APPLICATION_JSON)
        public Response listaBikes (@PathParam("idStation") String idStation) throws StationException
        {  //->Te inventas una respuesta llamada así, como es un get no pide nada
            try {
                List<Bike> bikeList = new LinkedList<Bike>();
                bikeList = mb.listabicis(idStation);

                return Response.status(201).entity(bikeList).build(); //porque no hay bucles
            } catch (StationException e) {
                e.printStackTrace();
                return Response.status(404).build();
            }
        }

        @POST
        @ApiOperation(value = "Añadir un usuario")

        @ApiResponses(value = {
                @ApiResponse( code = 201, message = "todo bien"),
        })
        @Path("/{añadirUsuario}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response añadirUsuario (User u) {
            mb.addUser(u.getIdUser(), u.getName(), u.getSurname());
            return Response.status(404).build();

        }
    }












