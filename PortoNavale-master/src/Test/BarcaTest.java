package Test;

import Base.*;
import static org.junit.Assert.assertEquals;
import java.time.LocalTime;
import org.junit.Test;


public class BarcaTest 
{			//setter e getter sono testati contemporaneamente nello stesso metodo, prima immetendo i dati direttamente e ottenendoli (get) e poi settandoli (set) con gli appositi metodi e riottendoli ancora corretti

	@Test
	public void testBarcaIntStringIntIntBoolean() throws Exception 
	{
		LocalTime tempo = LocalTime.now();
		tempo = tempo.minusSeconds(tempo.getSecond());
		tempo = tempo.minusNanos(tempo.getNano());
		Barca barca = new Barca(123, "Ciao ", LocalTime.now().getHour(), LocalTime.now().getMinute(), false);
		assertEquals(barca.getCodice(), 123);
		assertEquals(barca.getPortoProvenienza(), "Ciao ");
		assertEquals(barca.getSos(), false);
		assertEquals(barca.getOrarioArrivo(), tempo);
	}

	@Test
	public void testBarcaBarca() throws Exception 
	{
		LocalTime tempo = LocalTime.now();
		tempo = tempo.minusSeconds(tempo.getSecond());
		tempo = tempo.minusNanos(tempo.getNano());
		Barca barca = new Barca(123, "Ciao ", LocalTime.now().getHour(), LocalTime.now().getMinute(), false);
		Barca barcaCopia = new Barca(barca);
		assertEquals(barcaCopia.getCodice(), 123);
		assertEquals(barcaCopia.getPortoProvenienza(), "Ciao ");
		assertEquals(barcaCopia.getSos(), false);
		assertEquals(barcaCopia.getOrarioArrivo(), tempo);
		
	}

	@Test
	public void testBarca() throws Exception 
	{
		Barca barca = new Barca();
		assertEquals(barca.getCodice(), 0);
		assertEquals(barca.getPortoProvenienza(), "");
		assertEquals(barca.getSos(), false);
		assertEquals(barca.getOrarioArrivo(), barca.getOrarioArrivo());
	}

	@Test
	public void testGetCodice() throws Exception 
	{
		Barca barca = new Barca(123, "Ciao ", LocalTime.now().getHour(), LocalTime.now().getMinute(), false);
		assertEquals(barca.getCodice(), 123);
		barca.setCodice(582);
		assertEquals(barca.getCodice(), 582);
	}

	@Test
	public void testGetPortoProvenienza() throws Exception 
	{
		Barca barca = new Barca(123, "Ciao ", LocalTime.now().getHour(), LocalTime.now().getMinute(), false);
		assertEquals(barca.getPortoProvenienza(), "Ciao ");
		barca.setPortoProvenienza("Ecco qui che va");
		assertEquals(barca.getPortoProvenienza(), "Ecco qui che va");
	}

	@Test
	public void testGetOrarioArrivo() throws Exception 
	{
		LocalTime tempo = LocalTime.now();
		tempo = tempo.minusSeconds(tempo.getSecond());
		tempo = tempo.minusNanos(tempo.getNano());
		Barca barca = new Barca(123, "Ciao ", LocalTime.now().getHour(), LocalTime.now().getMinute(), false);
		assertEquals(barca.getOrarioArrivo(), tempo);
		barca.setOrarioArrivo(tempo.plusHours(2));
		assertEquals(barca.getOrarioArrivo(), tempo.plusHours(2));
		
	}

	@Test
	public void testGetSos() throws Exception 
	{
		Barca barca = new Barca(123, "Ciao ", LocalTime.now().getHour(), LocalTime.now().getMinute(), true);
		assertEquals(barca.getSos(), true);
		barca.setSos(false);
		assertEquals(barca.getSos(), false);
	}

}
