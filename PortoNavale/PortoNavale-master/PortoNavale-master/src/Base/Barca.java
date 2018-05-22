package Base;
import java.io.FileInputStream;
import java.time.LocalTime;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * La classe Barca rappresenta una barca in arrivo al porto. La barca è costitutita dai seguenti attributi:
 * un codice, il porto di provenienza, l'orario dell'arrivo e un segnale sos in caso di emergenza.
 * @version 1.0
 * @author Manuel Lini
 *
 */

public class Barca implements Serializable
{
	//Attributi
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
	
	/**
	 * Metodo Barca che ti permettere di istanziare gli oggetti
	 */
	
	public Barca(int codice, String portoProvenienza,int ore,int minuti,boolean sos)
	{
		setCodice(codice);
		setPortoProvenienza(portoProvenienza);
		setOrarioArrivo(ore, minuti);
		setSos(sos);
	}
	/**
	 * Costruttore del metodo Barca.
	 */
	public Barca(Barca barca)
	{
		setCodice(barca.getCodice());
		setPortoProvenienza(barca.getPortoProvenienza());
		setOrarioArrivo(barca.getOrarioArrivo());
		setSos(barca.getSos());
	}
	/**
	 * 
	 */
	public Barca()
	{
		this.codice=0;
		this.portoProvenienza="";
		this.orarioArrivo=null;
		this.sos=false;
		this.orarioArrivo = LocalTime.now();
	}
	/**
	 * Metodo getter che restituisce l'attributo codice
	 * @return codice 
	 */
	public int getCodice() 
	{
		return codice;
	}
	/**
	 * Metodo setter che consente di impostare l'attributo codice
	 */
	public void setCodice(int codice) 
	{
		this.codice = codice;
	}
	/**
	 * Metodo getter che restituisce l'attributo PortoProvenienza
	 * @return portoProvenienza
	 */
	public String getPortoProvenienza() 
	{
		return portoProvenienza;
	}
	/**
	 * Metodo setter che consente di impostare l'attributo PortoProvenienza
	 */
	public void setPortoProvenienza(String portoProvenienza) 
	{
		this.portoProvenienza = portoProvenienza;
	}
	/**
	 * Metodo setter consente di impostare l'attributo orarioArrivo 
	 */
	public void setOrarioArrivo(LocalTime orarioArrivo) 
	{
		this.orarioArrivo = orarioArrivo;
	} 


	/**
	 * Metodo getter che restituisce l'attributo orarioArrivo
	 * @return orarioArrivo
	 */
	public LocalTime getOrarioArrivo() 
	{
		return orarioArrivo;
	}
	/**
	 * Metodo setter consente di impostare l'attributo orarioArrivo 
	 */
	public void setOrarioArrivo(int ore, int minuti) 
	{
		orarioArrivo=LocalTime.of(ore, minuti);
	}
	/**
	 * Metodo getter che restituisce l'attributo Sos
	 * @return sos
	 */
	public boolean getSos() 
	{
		return sos;
	}
	/**
	 * Metodo setter che consente di impostare l'attributo Sos
	 */
	public void setSos(boolean sos) 
	{
		this.sos = sos;
	}
	/**
	 * Metodo toString per visualizzare i valori degli attributi
	 */
	public String toString()
	{
		return("Codice= "+getCodice()+'\t'+"Porto provenienza= "+getPortoProvenienza()+'\t'+"Orario arrivo="+getOrarioArrivo().getHour()+":"+getOrarioArrivo().getMinute()+'\n');
	}
}


