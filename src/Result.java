public class Result {
	public int hits;
	public int psuedoHits;
	@Override
	public String toString() {
		return hits + " hits and " + psuedoHits + " psuedo-hits";
	}
}