package epsi.exception;

public class ArtistNotFoundException extends Exception {

	@Override
	public String toString() {
		return "artist not found";
	}
}
