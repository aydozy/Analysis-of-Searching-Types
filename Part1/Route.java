//---------------------------------------------
// Title: Route Class
// Author: Ayda Nil Özyürek
// Description: This class uses for compare two string.
//---------------------------------------------

public class Route implements Comparable<Route> {

	// The variables we were asked to create in step 5.
	public String source;
	public String destination;

	public Route(String source, String destination) {
		// constructor
		this.destination = destination;
		this.source = source;
	}

	@Override
	public int compareTo(Route that) {
		// -----------------------------------------------
		// Summary: The part where the destination and source strings are compared.
		// -----------------------------------------------
		if (this.source.compareTo(that.source) == 0) {
			if (this.destination.compareTo(that.destination) < 0) {
				return -1; // this.destination is bigger than that.destination
			}
			if (this.destination.compareTo(that.destination) > 0) {
				return 1; //this.destination is smaller than that.destination
			}
		}
		if (this.source.compareTo(that.source) < 0) {
			return -1; // this.source is bigger than that.source
		}
		if (this.source.compareTo(that.source) > 0) {
			return 1; // this.source is smaller than that.source
		}
		return 0; // it means that they are equal
	}

}
