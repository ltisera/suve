package datos;

public enum TipoTransporte{
	Tren{
		public String toString() {
			return ("Tren");
		}
	}, 
	Colectivo{
		public String toString() {
			return ("Bondi");
		}
	}, 
	subte{
		public String toString() {
			return ("Sute");
		}
	}
	
}