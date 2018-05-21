package Test;

import static org.junit.Assert.assertEquals;
import java.time.*;
import org.junit.Test;
import Base.*;

public class PortoTest {
	LocalDateTime now = LocalDateTime.now();
	Barca P0 = new Barca(0, "Malonno", 15, 12, false);
	Barca P1 = new Barca(1, "Bossico", 17, 24, true);
	Barca P2 = new Barca(2, "Vezza", 19, 36, false);
	
	@Test
	public void testPorto() throws Exception 
	{
		Porto Lista = new Porto();
		assertEquals(Lista.getElementi(), 0); //ha settato correttamente gli elementi quindi anche l'head
	}

	@Test
	public void testGetElementi() throws Exception 
	{
		Porto Lista = new Porto();
		assertEquals(Lista.getElementi(), 0);
		Lista.inserisciInTesta(P0);
		assertEquals(Lista.getElementi(), 1);
	}

	@Test
	public void testInserisciInTesta() throws Exception 
	{
		Porto Lista = new Porto();
		Lista.inserisciInTesta(P0);
		assertEquals(Lista.getBarca(1).getCodice(), P0.getCodice());
	}

	@Test
	public void testInserisciInCoda() throws Exception 
	{
		Porto Lista = new Porto();
		Lista.inserisciInTesta(P0);	//pongo questo oggetto in testa
		Lista.inserisciInTesta(P1);	//ora pongo questo in testa quindi P0 slitta di una posizione, slitta in coda
		assertEquals(Lista.getBarca(2).getCodice(), P0.getCodice());  //e qui lo verifico
		Lista.inserisciInCoda(P2);  //ora metto P2 in coda
		assertEquals(Lista.getBarca(3).getCodice(), P2.getCodice()); //e qui verifico
	}

	@Test
	public void testInserisciInPosizione() throws Exception 
	{
		Porto Lista = new Porto();
		Lista.inserisciInTesta(P0);
		Lista.inserisciInTesta(P1);
		Lista.inserisciInTesta(P2); //a questo punto la lista è composta da 1)P2 2)P1 3)P0
		Lista.inserisciInposizione(P0, 2); //ora se ha funzionato dovrebbe essere 1)P2 2)P0 3) P1 4) P0
		assertEquals(Lista.getBarca(1).getCodice(), P2.getCodice());
		assertEquals(Lista.getBarca(2).getCodice(), P0.getCodice());
		assertEquals(Lista.getBarca(3).getCodice(), P1.getCodice());
		assertEquals(Lista.getBarca(4).getCodice(), P0.getCodice());	//accertato e corretto
	}

	@Test
	public void testEliminaInTesta() throws Exception 
	{
		Porto Lista = new Porto();
		Lista.inserisciInTesta(P0);
		Lista.inserisciInTesta(P1);
		Lista.inserisciInTesta(P2); //a questo punto la lista è composta da 1)P2 2)P1 3)P0
		Lista.eliminaInTesta(); //Ora sarà 1)P1 2)P0
		assertEquals(Lista.getBarca(1).getCodice(), P1.getCodice()); //ecco qui la prova
	}

	@Test
	public void testEliminaInCoda() throws Exception 
	{
		Porto Lista = new Porto();
		Lista.inserisciInTesta(P0);
		Lista.inserisciInTesta(P1);
		Lista.inserisciInTesta(P2); //a questo punto la lista è composta da 1)P2 2)P1 3)P0
		Lista.eliminaInCoda(); //Ora sarà 1)P2 2)P1
		assertEquals(Lista.getBarca(1).getCodice(), P2.getCodice());
		assertEquals(Lista.getBarca(2).getCodice(), P1.getCodice());
	}

	@Test
	public void testEliminaInPosizione() throws Exception 
	{
		Porto Lista = new Porto();
		Lista.inserisciInTesta(P0);
		Lista.inserisciInTesta(P1);
		Lista.inserisciInTesta(P2); //a questo punto la lista è composta da 1)P2 2)P1 3)P0
		Lista.eliminaInPosizione(2); //ora elimino P1 e diventa 1)P2 2)P0
		assertEquals(Lista.getBarca(1).getCodice(), P2.getCodice()); //ecco la prova
		assertEquals(Lista.getBarca(2).getCodice(), P0.getCodice());
		Lista.eliminaInPosizione(2); //ora rimane solo P2
		assertEquals(Lista.getBarca(1).getCodice(), P2.getCodice());
		
	}

	@Test
	public void testGetBarca() throws Exception 
	{
		Porto Lista = new Porto();
		Lista.inserisciInTesta(P0);
		Lista.inserisciInTesta(P1);
		Lista.inserisciInCoda(P2);
		assertEquals(Lista.getBarca(1).getCodice(), P1.getCodice());
		assertEquals(Lista.getBarca(2).getCodice(), P0.getCodice());
		assertEquals(Lista.getBarca(3).getCodice(), P2.getCodice());
		
	}

}
