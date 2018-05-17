import java.io.FileInputStream;
import java.time.LocalTime;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * La classe Barca rappresenta una barca in arrivo al porto. La barca è costitutita dai seguenti attributi:+
 * un codice, il porto di provenienza, l'orario dell'arrivo e un segnale sos in caso di emergenza.
 * @version 1.0
 * @author Manuel
 *
 */

public class Barca implements Serializable
{
	private int codice;
	private String portoProvenienza;
	private LocalTime orarioArrivo;
	private boolean sos;
	/**
	 * 
	 * @param codice Indica il codice della barca registrata
	 * @param portoProvenienza Indica il porto in cui era precedentemente la barca registrata
	 * @param orarioArrivo Indica l'orario di arrivo della barca registrata
	 * @param sos Indica in caso di emergenza il segnale con cui automaticamenente la barca avrà la precedenza su tutte le altre
	 */
	
	public Barca(int codice, String portoProvenienza,int ore,int minuti,boolean sos)
	{
		setCodice(codice);
		setPortoProvenienza(portoProvenienza);
		setOrarioArrivo(ore, minuti);
		setSos(sos);
	}
	
	/**
	 * Metodo Barca che ti permettere di istanziare gli oggetti
	 */
	public Barca(Barca barca)
	{
		setCodice(barca.getCodice());
		setPortoProvenienza(barca.getPortoProvenienza());
		setOrarioArrivo(barca.getOrarioArrivo());
		setSos(barca.getSos());
	}
	/**
	 * Costruttore del metodo Barca
	 */

	public int getCodice() 
	{
		return codice;
	}
	/**
	 * Metodo getter dell'attributo codice 
	 */

	public void setCodice(int codice) 
	{
		this.codice = codice;
	}
	/**
	 * Metodo setter dell'attributo codice
	 */

	public String getPortoProvenienza() 
	{
		return portoProvenienza;
	}
	/**
	 * Metodo getter dell'attributo PortoProvenienza
	 */

	public void setPortoProvenienza(String portoProvenienza) 
	{
		this.portoProvenienza = portoProvenienza;
	}
	/**
	 * Metodo setter dell'attributo PortoProvenienza
	 */

	public void setOrarioArrivo(LocalTime orarioArrivo) 
	{
		this.orarioArrivo = orarioArrivo;
	} 


	public boolean getSos() 
	{
		return sos;
	}
	/**
	 * Metodo getter dell'attributo Sos
	 */

	public void setSos(boolean sos) 
	{
		this.sos = sos;
	}
	/**
	 * Metodo setter dell'attributo Sos
	 */
	public String toString()
	{
		return(getCodice()+" "+getPortoProvenienza()+" "+getOrarioArrivo());
	}
	/**
	 * Metodo toString per visualizzare i valori degli attributi
	 */

	public LocalTime getOrarioArrivo() 
	{
		return orarioArrivo;
	}

	public void setOrarioArrivo(int ore, int minuti) 
	{
		orarioArrivo=LocalTime.of(ore, minuti);
	}
}


