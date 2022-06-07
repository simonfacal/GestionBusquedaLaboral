package tablas;

public class Locacion_Indistinto implements ILocacion {
	
	@Override
	public double comparaCon(ILocacion locacion) {
		return locacion.comparaConIndistinto();
	}
	
    	@Override
	  public double comparaConPresencial() {
	  	return -1;
  	}

	  @Override
	  public double comparaConHomeOffice() {
	  	return 1;
	  }

	  @Override
  	public double comparaConIndistinto() {
  		return 1;
  	}
	  @Override
		public String toString() {
			return " indistinto";
		}
}