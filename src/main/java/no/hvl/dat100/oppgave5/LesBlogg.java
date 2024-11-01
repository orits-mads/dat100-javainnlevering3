package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		Blogg samling = null;
		
		
		try (BufferedReader reader = new BufferedReader(new FileReader(mappe + "/" + filnavn))) {
			String førstelinje = reader.readLine();
			int linje = Integer.parseInt(førstelinje);
			
			samling = new Blogg(linje);
			for(int i = 0; i < linje; i++) {
				String innhold = reader.readLine();
				
				if(innhold.equals(TEKST)) {
					int id = Integer.parseInt(reader.readLine().trim());
					String bruker = reader.readLine().trim();
					String dato = reader.readLine().trim();
					int likes = Integer.parseInt(reader.readLine().trim());
					String tekst = reader.readLine().trim();
					
					Tekst innlegg = new Tekst(id, bruker, dato, likes, tekst);
					samling.leggTil(innlegg);
					
				}else if(innhold.equals(BILDE)) {
					int id = Integer.parseInt(reader.readLine().trim());
					String bruker = reader.readLine().trim();
					String dato = reader.readLine().trim();
					int likes = Integer.parseInt(reader.readLine().trim());
					String tekst = reader.readLine().trim();
					String url = reader.readLine().trim();
					
					Bilde innlegg = new Bilde(id, bruker, dato, likes, tekst, url);
					samling.leggTil(innlegg);
				}
			}

			
		} catch(IOException e) {
			System.out.println("Fil ikke innlegg: " + e.getMessage());
			
		}
	return samling;
		
	}
}
