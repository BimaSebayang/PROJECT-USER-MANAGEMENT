package id.co.roxas.common.lib.helper;

public class DigraphSet extends GraphSet {

	
	@Override
	public void addEdge(String label1, String label2) {
		adjVertices.get(label1).add(label2);
		EDGE_VOLUMES++;
	}

}
