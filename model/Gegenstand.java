package model;

public class Gegenstand {
	private String name;
	private String beschreibung;
	private double gewicht;
	private boolean magic = false;
	
	public Gegenstand() {
		this.name = "Gegenstand";
		this.beschreibung = "Ein Gegenstand";
		this.gewicht = 1f;
	}
	
	public Gegenstand(String name, String beschreibung, double gewicht) {
		this.name = name;
		this.beschreibung = beschreibung;
		this.gewicht = gewicht;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + ", " + beschreibung;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBeschreibung() {
		return beschreibung;
	}



	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}



	public double getGewicht() {
		return gewicht;
	}



	public void setGewicht(float gewicht) {
		this.gewicht = gewicht;
	}

	public boolean isMagic() {
		return magic;
	}

	public void setMagic(boolean magic) {
		this.magic = magic;
	}
}
