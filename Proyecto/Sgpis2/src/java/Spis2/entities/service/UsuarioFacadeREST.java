/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spis2.entities.service;

import Spis2.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;

/**
 *
 * @author carlos
 */
@Stateless
@Path("spis2.entities.usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "Sgpis2PU")
    private EntityManager em;

    public UsuarioFacadeREST() {
        super(Usuario.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    //@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Usuario entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    //@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuario find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    //@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) Original
    @Produces(MediaType.APPLICATION_JSON)//modificado
    public List<Usuario> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    /*Se crea el servicio rest para el login*/
    @POST
    @Path("login")//como se va a acceder al login
    @Produces(MediaType.TEXT_PLAIN)//lo que va a retornar
    @Consumes(MediaType.APPLICATION_JSON)//lo que recibe
    //@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Override
    public boolean login(Usuario entity){
        /*se llama a ala funcion de la clase abstracta*/
        return super.login(entity);
    }
    
        /*Se crea el servicio rest para el login*/
    @POST
    @Path("login_object")//como se va a acceder al login
    @Produces(MediaType.APPLICATION_JSON)//lo que va a retornar
    @Consumes(MediaType.APPLICATION_JSON)//lo que recibe
    @Override
    public String login_object(Usuario entity){
        /*se llama a ala funcion de la clase abstracta*/
        return super.login_object(entity);
    }
    
    @POST
    @Path("tareas_usuario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)//lo que recibe
    @Override
    public String tareas_usuario( Usuario id_usuario) {
        return super.tareas_usuario(id_usuario);
    }
    
}
