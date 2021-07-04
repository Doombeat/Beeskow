package esa_ale;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*********************************************************
* @author Kevin Beeskow (s77793@beuth-hochschule.de)	
* @version 1.0, 04/2021
* Einsendeaufgabe ALE-E1 Telefonnummernliste
*********************************************************/

public class Telefonliste {

	// Initialisierung: Telefonliste
	private ArrayList<TelefonEintrag> telefonlist;

	/**
	 * Aufruf des Konstruktors
	 */
	
	public Telefonliste() {
		telefonlist = new ArrayList<TelefonEintrag>();
	}

	/**
	 * Fuegt der Telefonliste einen weiteren Eintrag hinzu
	 * @param name
	 * @param number
	 */
	
	public void addEntry(String name, String number) {
		telefonlist.add(new TelefonEintrag(name, number));
	}

	/**
	 * Modifiziert den Eintrag innerhalb der Telefonliste
	 * @param name
	 * @param number
	 * @param nameNew
	 * @param numberNew
	 */
	
    protected boolean modifyEntry (String name, String number, String nameNeu, String numberNeu){

        TelefonEintrag neuerEintrag = new TelefonEintrag(nameNeu, numberNeu);
        
        boolean replace;
        
        List<TelefonEintrag> ergebnis = telefonlist.stream()
                .filter(e -> e.getName().equals(name) && e.getNumber().equals(number))
                .collect(Collectors.toList());

        replace = !ergebnis.isEmpty();
        if (replace) ergebnis.forEach(e -> telefonlist.set(telefonlist.indexOf(e), neuerEintrag));

        return replace;
    }

	/**
	 * Löscht einen einzelnen Eintrag (Name & Rufnummer) aus der Telefonliste
	 * @param name 
	 * Name des zu loeschenden Eintrags
	 * @param number
	 * Nummer des zu loeschenden Eintrags
	 */
    
	public void removeEntry(String name, String number) {
		// Die Variable t1 dient hier zur Zwischenspeicherung
		TelefonEintrag t1 = null;
		// Die Telefonliste wird durchsucht
		for (TelefonEintrag t0 : telefonlist) {
			if (t0.getName().equals(name) || t0.getNumber().equals(number)) {
				// Der gefundene Eintrag wird in t1 zwischengespeichert 
				t1 = t0;
				break;
			}
		}
		
		// t1 wird nun aus der Liste entfernt
		if (t1 != null)
			telefonlist.remove(t1);
	}

	/**
	 * Gibt die Groeße der Instanz telefonlist zurueck
	 * @return size
	 */
	
	public Object size() {
		return telefonlist.size();
	}

	/**
	 * Bereinigt die Telefonliste
	 */
	
	public void clear() {
		telefonlist.clear();
	}

	/**
	 * Durchsucht die Telefonliste nach Namen
	 */
	
	public Object searchByName(String name) {
		for (TelefonEintrag t : telefonlist) {
			if (t.getName().equals(name)) {
				return t.toString();
			}
		}
		return null;
	}

	/**
	 * Durchsucht die Telefonliste nach einer Nummern
	 */
	
	public Object searchNameByNumber(String number) {
		for (TelefonEintrag t : telefonlist) {
			if (t.getNumber().equals(number)) {
				return t.toString();
			}
		}
		return null;
	}
}

