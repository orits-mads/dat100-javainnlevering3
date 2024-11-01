package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;		// Viser også til antall innlegg i tabellen

	public Blogg() {
		this.innleggtabell = new Innlegg[20];
		this.nesteledig = 0;
	}

	public Blogg(int lengde) {
		this.innleggtabell = new Innlegg[lengde];
		this.nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].getId() == innlegg.getId()) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) >= 0;
	}

	public boolean ledigPlass() {
		return nesteledig < innleggtabell.length - 1;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (!finnes(innlegg)) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		return false;
	}
	
	public String toString() {
		String utskrift = "";
		utskrift += nesteledig;

		for (int i = 0; i < nesteledig; i++){
			utskrift += innleggtabell[i].toString() + "\n";
		}
		return utskrift;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		// Oppretter ny midlertidig tabell med dobbel lengde
		Innlegg[] temp = new Innlegg[innleggtabell.length * 2];

		// Kopierer alle elementene inn i den midlertidige tabellen
		for (int i = 0; i < innleggtabell.length - 1; i++) {
			temp[i] = innleggtabell[i];
		}

		innleggtabell = temp;

	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if (ledigPlass() && !finnes(innlegg)) {
			leggTil(innlegg);
		} else {
			utvid();
			leggTil(innlegg);
		}

		return true;
	}
	
	public boolean slett(Innlegg innlegg) {
		int index = finnInnlegg(innlegg);

		if (index >= 0) {
			innleggtabell[index] = innleggtabell[nesteledig - 1];
			innleggtabell[nesteledig - 1] = null;
			nesteledig--;
			return true;
		}
	
		return false;
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}