package id.co.roxas.common.lib.tester;

import com.google.gson.Gson;

import id.co.roxas.common.lib.helper.DigraphSet;
import id.co.roxas.common.lib.helper.GraphSet;

public class TesterTrees {

	public static void main(String[] args) {
		DigraphSet graph = new DigraphSet();
		
		graph.addVertex("20");
		graph.addVertex("21");
		graph.addVertex("22");
		graph.addVertex("23");
		
		graph.addEdge("22", "23");
		
		System.err.println("all adj " + new Gson().toJson(graph.getAllAdjecentVerticesInNDegree("22", 1)));
	}

}
