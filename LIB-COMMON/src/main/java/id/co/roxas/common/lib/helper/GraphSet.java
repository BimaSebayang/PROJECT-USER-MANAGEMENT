package id.co.roxas.common.lib.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GraphSet {

	public Map<String, List<String>> adjVertices = new HashMap<>();
	public static final int ADJ_TRUE = 1;
	public static final int ADJ_FALSE = 0;
	public int VERTEX_VOLUMES = 0;
	public int EDGE_VOLUMES = 0;
	
	public void addVertex(String label) {
		adjVertices.putIfAbsent(label, new ArrayList<>());
		VERTEX_VOLUMES++;
	}
	
	public List<String> getAllVertices() {
		if (adjVertices == null || adjVertices.size() == 0) {
			return null;
		}
		List<String> getAllVertices = new ArrayList<>();
		adjVertices.keySet().stream().forEach(e -> getAllVertices.add(e));
		return getAllVertices;
	}

	
	public void addEdge(String label1, String label2) {
		///if(adjVertices.get(label1))
		
		adjVertices.get(label1).add(label2);
		EDGE_VOLUMES++;
		
		if(!label1.equals(label2)) {
		adjVertices.get(label2).add(label1);
		EDGE_VOLUMES++;
		}
	}

	public List<Path> getAllAdjecentVerticesInNDegree(String label1, int degree) {
		List<Path> pathw = new ArrayList<>();
		int i = degree;
		while (i != 0) {
			if (i == degree) {
				List<String> edges = getAllEdges().stream().filter(e -> e.getLabelX().equals(label1))
						.map(e -> e.getLabelY()).collect(Collectors.toList());
				for (String edge : edges) {
					Path path = new Path(label1);
					path.addPath(edge);
					pathw.add(path);
				}
			} else {
				List<Path> paths = new ArrayList<>(pathw);
				pathw.clear();
				for (Path path : paths) {
					String labelX = path.getPath().lastElement();
					List<String> edges = getAllEdges().stream().filter(e -> e.getLabelX().equals(labelX))
							.map(e -> e.getLabelY()).collect(Collectors.toList());
					for (String edge : edges) {
						Path path2 = new Path(path.getPath());
						path2.addPath(edge);
						pathw.add(path2);
					}
				}
			}
			i--;
		}
		List<Path> getTruePath = pathw.stream().filter(e -> e.path.size() - 1 == degree).collect(Collectors.toList());

		return getTruePath;
	}
	

	public List<Edge> getAllEdges() {
		if (adjVertices == null || adjVertices.size() == 0) {
			return null;
		}

		List<Edge> getAllEdged = new ArrayList<>();

		getAllVertices().stream()
				.forEach(vertex -> adjVertices.get(vertex).stream().forEach(e -> getAllEdged.add(new Edge(vertex, e))));

		return getAllEdged;
	}
	
}
