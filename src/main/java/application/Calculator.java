package application;

/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;
	
	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}
	
	public double getLeistung() {
		return leistung;
	}
	
	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + 
				", spannung=" + spannung + 
				", strom=" + strom + 
				", widerstand="	+ widerstand + "]";
	}

	public void calculate() {
		if(getLeistung() > 0 && getSpannung() > 0){
			iFromPandU(getLeistung(), getSpannung());
			rFromPandU(getLeistung(), getSpannung());
		}else if(getStrom() > 0 && getWiderstand() > 0){
			pFromRandI(getWiderstand(), getStrom());
			uFromRannI(getWiderstand(), getStrom());
		}else if(getLeistung() > 0 && getStrom() > 0){
			uFromPannI(getLeistung(), getStrom());
			rFromPandI(getLeistung(), getStrom());
		}else if(getSpannung() > 0 && getWiderstand() > 0){
			pFromUandR(getSpannung(), getWiderstand());
			iFromUandR(getSpannung(), getWiderstand());
		}else if(getLeistung() > 0 && getWiderstand() > 0){
			uFromPandR(getLeistung(), getWiderstand());
			iFromPandR(getLeistung(), getWiderstand());
		}else if(getStrom() > 0 && getSpannung() > 0){
			pFromUandI(getSpannung(), getStrom());
			rFromUandI(getSpannung(), getStrom());
		}
	}

	//Methods for calculations

	//Formulas with P
	public double pFromUandI(double u, double i){
		return u * i;
	}

	public double pFromRandI(double r, double i){
		double val = i * i;
		return r * val;
	}

	public double pFromUandR(double u, double r) {
		double val = u * u;
		return val / r;
	}

	//Formulas with I
	public double iFromPandU(double p, double u){
		return p / u;
	}
	public double iFromUandR(double u, double r){
		return u / r;
	}
	public double iFromPandR(double p, double r){
		return Math.sqrt(p / r);
	}

  
	//Formulas with U
	public  double uFromRannI(double r,double i){
		return r * i;
	}

	public  double uFromPannI(double p,double i){
		return p / i;
	}

	public  double uFromPandR(double p,double r){
		double val = p * r;
		return  Math.sqrt(val);
	}

	//Formulas with R
	public  double rFromUandI(double u,double i){
		return u / i;
	}
	public  double rFromPandI(double p,double i){
		double val = i * i;
		return p / val;
	}
	public  double rFromPandU(double p,double u){
		double val = u * u;
		return val / p;
	}
}
