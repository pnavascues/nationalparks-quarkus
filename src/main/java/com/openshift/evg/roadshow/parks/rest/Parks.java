package com.openshift.evg.roadshow.parks.rest;

import com.mongodb.BasicDBObject;
import com.openshift.evg.roadshow.parks.db.MongoDBConnection;
import com.openshift.evg.roadshow.parks.model.Park;
import org.bson.Document;
/* import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*; */

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;

/* @RequestMapping("/ws/data")
@RestController
 */

@Path("/ws/data")
@Produces(MediaType.APPLICATION_JSON)      
@Consumes(MediaType.APPLICATION_JSON)       
public class Parks {

    
    private final MongoDBConnection con;

    @Inject
    public Parks(MongoDBConnection connection) {
        this.con = connection;
    }
 /*     @CrossOrigin
    @Path("/load")
    @Produces(MediaType.APPLICATION_JSON)      
    @Consumes(MediaType.APPLICATION_JSON)       
    @GET
    // @RequestMapping(method = RequestMethod.GET, value = "/load", produces = "application/json")
    public String load() {
        System.out.println("[INFO] load()");
        List<Document> l = con.loadParks();
        con.init(l);
        return "Items inserted in database: " + con.sizeInDB();
    }
 */
    // @CrossOrigin
    // @RequestMapping(method = RequestMethod.GET, value = "/all", produces = "application/json")
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)      
    @Consumes(MediaType.APPLICATION_JSON)       
    @GET
    public List<Park> getAllParks() {
        System.out.println("[DEBUG] getAllParks");

        return con.getAll();
    }
/* 
    @CrossOrigin
    // @RequestMapping(method = RequestMethod.GET, value = "/within", produces = "application/json")
    @Path("/within")
    @Produces(MediaType.APPLICATION_JSON)      
    @Consumes(MediaType.APPLICATION_JSON)       
    @GET
    public List<Park> findParksWithin(
            // @RequestParam("lat1") float lat1,
            // @RequestParam("lon1") float lon1,
            // @RequestParam("lat2") float lat2,
            // @RequestParam("lon2") float lon2) {
                @PathParam("lat1") float lat1,
                @PathParam("lon1") float lon1,
                @PathParam("lat2") float lat2,
                @PathParam("lon2") float lon2) {                
        System.out.println("[DEBUG] findParksWithin(" + lat1 + "," + lon1 + "," + lat2 + "," + lon2 + ")");

        // make the query object
        BasicDBObject spatialQuery = new BasicDBObject();

        ArrayList<double[]> boxList = new ArrayList<double[]>();
        boxList.add(new double[]{new Float(lat1), new Float(lon1)});
        boxList.add(new double[]{new Float(lat2), new Float(lon2)});

        BasicDBObject boxQuery = new BasicDBObject();
        boxQuery.put("$box", boxList);

        spatialQuery.put("coordinates", new BasicDBObject("$within", boxQuery));
        System.out.println("Using spatial query: " + spatialQuery.toString());

        return con.getByQuery(spatialQuery);
    } */

/*     @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/centered", produces = "application/json")
    public List<Park> findParksCentered(@RequestParam("lat") float lat, @RequestParam("lon") float lon, @RequestParam("maxDistance") int maxDistance, @RequestParam("minDistance") int minDistance) {


        // TODO: Implement this
        return null;
    } */
}
