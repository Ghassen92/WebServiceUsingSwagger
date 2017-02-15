package tn.sifast.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import tn.sifast.bean.Ingenieur;
import tn.sifast.dao.DaoFactory;
import tn.sifast.dao.IngenieurDao;
	
@Api(value = "/",tags = "Ingenieur")
@Path("/")
 public class IngenieurRest {

	DaoFactory dao;
	IngenieurDao ingenieurDao;

	public IngenieurRest() {
		dao=DaoFactory.getInstance();
		ingenieurDao=dao.getBeanDao();
 	}
	
	@GET
	@Path("/ing")
	@Produces(APPLICATION_JSON)
	@ApiOperation(	value = "retourner tous les ingénieurs",
					notes = "notes...",
 					produces=APPLICATION_JSON)
	@ApiResponses(value = {
							@ApiResponse(code = 200, message = "OK"),
							@ApiResponse(code = 500, message = "erreur lors de communication avec le serveur")})
	public List<Ingenieur> getAll() {
		return   ingenieurDao.getAll();
	}


	@POST
	@Path("/ing")
	@Produces(TEXT_PLAIN)
	@ApiOperation(  value = "créer un ingenieur",
					notes = "notes...",
					produces=TEXT_PLAIN)
	public int setBean( @ApiParam(value="nom" ,required=true)  @FormParam(value="nom")String nom,
						@ApiParam(value="prenom" ,required=true) @FormParam(value="prenom")String prenom) {
		return ingenieurDao.createBean(new Ingenieur(nom,prenom));
	} 
	
	@DELETE
	@Path("/ing")
	@Produces(TEXT_PLAIN)
	@ApiOperation(  value = "supprimer un ingenieur",
					notes = "notes...",
					produces=TEXT_PLAIN)
	public int deleteBean( @ApiParam(value="id" ,required=true)  @FormParam(value="id")int id) {
		return ingenieurDao.delete(id);
	} 
	
	
	@GET
	@Path("/ing/{id}")
	@Produces(APPLICATION_JSON)
	@ApiOperation(	value = "retourner l'ingenieur demandé",
					notes = "notes...",
					produces=APPLICATION_JSON)
	public Ingenieur getBean( @ApiParam(value="id" ,required=true) @PathParam(value="id")int id) {
		return ingenieurDao.get(id);
	}
	
}
