package no.hvl.dat100.oppgave6;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;
import no.hvl.dat100.oppgave3.Blogg;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}
	
	private static String HTMLPREFIX = 
			"<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";
	
	private static String HTMLPOSTFIX = 
			"\t</body>\n</html>";
	
	@Override
	public String toString() {
		StringBuilder html = new StringBuilder();
		
		html.append(HTMLPREFIX);
		
		for (Innlegg innlegg : getSamling()) {
			if(innlegg != null) {
			html.append(innlegg.toHTML());
		}
	}
		
		html.append(HTMLPOSTFIX);
		
		return html.toString();
	}
}
