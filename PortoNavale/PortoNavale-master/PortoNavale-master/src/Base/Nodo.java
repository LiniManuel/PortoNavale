package Base;
import java.io.Serializable;
/**
 * Classe Nodo rappresenta i nodi che servono a costuire il Porto, gli attributi rappresentano.
 * la componente informativa, osia il processo di arrivo delle barche al porto con il relativi parametri.
 * e la componente link con il nodo successivo.
 * @version 1.0.
 * @author Manuel Lini.
 */

public class Nodo implements Serializable
{
	//Attributi
	private Barca info;
	private Nodo link;
	
	/**
	 * @param info contiene la parte informativa, cioè la barca.
	 * @param link contiene l'indirizzo al nodo successivo.
	 */
	
	/**
	 * Costruttore. Quandoviene istanziato un nuovo nodo la componente link viete settata a null.
	 * @param barca oggetto di tipo Barca che va a costituire la parte informativa del nodo.
	 */
	public Nodo (Barca barca)
	{
		setInfo(barca);
		link=null;
	}
	/**
	 * Metodo getter che restituisce la componente.
	 * @return info oggetto di tipo Barca.
	 */
	public Barca getInfo() 
	{
		return info;
	}
	/**
	 * Metodo setter che consente di settare la componenete informativa del nodo.
	 * @param info oggetto di tipo Barca.
	 */
	public void setInfo(Barca info) 
	{
		this.info = new Barca(info);
	}
	/**
	 * Metodo getter che restituisce la componente link del nodo.
	 * @return link reference del prossimo oggetto nodo.
	 */
	public Nodo getLink() 
	{
		return link;
	}
	/**
	 * Metodo setter che consente di settare la componente link del nodo.
	 * @param link reference del prossimo oggetto nodo.
	 */

	public void setLink(Nodo link) 
	{
		this.link = link;
	}

}
