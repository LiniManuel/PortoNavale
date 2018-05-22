package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Base.Barca;
import Base.Nodo;

public class NodoTest {
	
	Barca Barca = new Barca();
	Barca Barca2 = new Barca();

	@Test
	public void testNodo() throws Exception 
	{
		Nodo nodo = new Nodo(Barca);
		Nodo nodo2 = new Nodo(Barca2);		
		
		assertEquals(nodo.getInfo().getCodice(), Barca.getCodice());
		assertEquals(nodo.getLink(), null);
		nodo.setInfo(Barca2);
		nodo.setLink(nodo2);
		assertEquals(nodo.getInfo().getCodice(), Barca2.getCodice());
		assertEquals(nodo.getLink(), nodo2);
	}

	@Test
	public void testGetInfo() throws Exception 
	{
		Nodo nodo = new Nodo(Barca);
		assertEquals(nodo.getInfo().getCodice(), Barca.getCodice());
		nodo.setInfo(Barca2);
		assertEquals(nodo.getInfo().getCodice(), Barca2.getCodice());
	}

	@Test
	public void testGetLink() throws Exception 
	{
		Nodo nodo = new Nodo(Barca);
		Nodo nodo2 = new Nodo(Barca);
		assertEquals(nodo.getLink(), null);
		nodo.setLink(nodo2);
		assertEquals(nodo.getLink(), nodo2);
	}

}
