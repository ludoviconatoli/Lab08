package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private Graph <Airport, DefaultWeightedEdge> grafo;
	private ExtFlightDelaysDAO dao;
	private Map<Integer, Airport> idMap;
	
	public Model() {
		idMap = new HashMap<Integer, Airport>();
		dao = new ExtFlightDelaysDAO();
	}
	
	public Graph<Airport, DefaultWeightedEdge> creaGrafo(int distanza_media) {
		grafo = new SimpleWeightedGraph<Airport, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		List<Airport> aeroporti = dao.loadAllAirports();
		for(Airport a: aeroporti) {
			grafo.addVertex(a);
			idMap.put(a.getId(), a);
		}
		
		for(Adiacenza a: dao.creaArchi(distanza_media)) {
			Graphs.addEdge(grafo, idMap.get(a.getOrigin_id()), idMap.get(a.getDestination_id()), a.getDistanza());
		}
		
		return grafo;
	}
}
