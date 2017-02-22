package tn.sifast.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import tn.sifast.bean.Ingenieur;
import tn.sifast.dao.DaoFactory;
import tn.sifast.dao.IngenieurDao;
import tn.sifast.util.PATCH;

@Api(value = "/", tags = "Ingenieur")
@Path("/")
@Produces({ APPLICATION_JSON, TEXT_PLAIN })
public class IngenieurRest {

	DaoFactory dao;
	IngenieurDao ingenieurDao;
	final static Logger logger = Logger.getLogger(IngenieurRest.class);

	public IngenieurRest() {
		dao = DaoFactory.getInstance();
		ingenieurDao = dao.getIngenieurDao();
	}

	@GET
	@Path("/ing")
	@Produces(APPLICATION_JSON)
	@ApiOperation(value = "retourner tous les ingénieurs", notes = "notes...", produces = APPLICATION_JSON)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 500, message = "erreur lors de communication avec le serveur") })
	public List<Ingenieur> getAll() {
		return ingenieurDao.getAll();
	}

	@POST
	@Path("/ing")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(TEXT_PLAIN)
	@ApiOperation(value = "créer un ingenieur", notes = "notes...", produces = TEXT_PLAIN)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 500, message = "erreur lors de communication avec le serveur") })
	public int creerIngenieur(
			@ApiParam(value = "nom", required = true) @FormParam(value = "nom") String nom,
			@ApiParam(value = "prenom", required = true) @FormParam(value = "prenom") String prenom) {
		if (nom == null || prenom == null)
			return -1;
		logger.info("création de l'ingénieur" + nom + " " + prenom);
		return ingenieurDao.creerIngenieur(new Ingenieur(nom, prenom));
	}

	@DELETE
	@Path("/ing/{id}")
	@ApiOperation(value = "supprimer un ingenieur")
	@ApiResponses(value = { @ApiResponse(code = 400, message = ""),
			@ApiResponse(code = 404, message = "erreur") })
	public int supprimerIngenieur(
			@ApiParam(value = "ingénieur à supprimer", required = true) @PathParam("id") String idString) {
		int id = -1;
		try {
			id = Integer.parseInt(idString);
		} catch (Exception e) {
			logger.error("invalid id =" + idString);
		}
		logger.info("supprimer l'ingénieur d'id" + id);
		return ingenieurDao.delete(id);
	}

	@GET
	@Path("/ing/{id}")
	@Produces(APPLICATION_JSON)
	@ApiOperation(value = "retourner l'ingenieur demandé", notes = "notes...", produces = APPLICATION_JSON)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 500, message = "erreur lors de communication avec le serveur") })
	public Ingenieur retournerIngenieur(
			@ApiParam(value = "id", required = true) @PathParam(value = "id") int id) {
		logger.info("retourner  l'ingénieur d'id" + id);
		return ingenieurDao.get(id);
	}

	@PATCH
	@Path("/ing")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(TEXT_PLAIN)
	@ApiOperation(value = "modifier un ingénieur", httpMethod = "PATCH", produces = TEXT_PLAIN, consumes = MediaType.APPLICATION_FORM_URLENCODED)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 500, message = "erreur lors de communication avec le serveur") })
	public int modifierIngenieur(
			@ApiParam(value = "nom", required = true) @FormParam(value = "nom") String nom,
			@ApiParam(value = "prenom", required = true) @FormParam(value = "prenom") String prenom,
			@ApiParam(value = "id", required = true) @FormParam(value = "id") int id) {
		logger.info("modifier  l'ingénieur d'id" + id);
		return ingenieurDao.update(nom, prenom, id);
	}

}
