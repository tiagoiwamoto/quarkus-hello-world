package com.example;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/hello")
public class ExampleResource {

    @Inject
    private MyService myService;
    @Inject
    private MyEntityRepository myEntityRepository;

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response hello() {
//        MyEntity myEntity = new MyEntity();
//        myEntity.setField(myService.getProtocol());
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", RestResponse.StatusCode.OK);
//        map.put("message", "Sucesso");
//        map.put("data", myEntity);
//        map.put("protocol", this.myService.getProtocol());
//        Response response = Response.created(URI.create("")).entity(map).build();
//        return response;
//    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response salvar(MyEntity myEntity){
        MyEntity entityGravada = this.myEntityRepository.gravar(myEntity);
        return Response.created(URI.create("")).entity(entityGravada).build();
    }

    @GET
    public Response recuperarEntities(){
        return Response.ok(this.myEntityRepository.recoveryEntities()).build();
    }

    @DELETE
    @Path(value = "/{id}")
    @Transactional
    public Response deletarEntidade(@PathParam("id") Long id){
        String resposta = this.myEntityRepository.deleteMyEntity(id) ? "Removido com sucesso" : "Falha ao remover";
        return Response.ok(resposta).build();
    }
}