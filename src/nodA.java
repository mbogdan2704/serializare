/**
 * Clasa nodA
 * @author root
 *
 */
  public class nodA extends Nod{
	private String Name;
	private int Number; //Specifica numarul de ordine in nod_list
	private int indice; // 0,1,2-specifica versiunea de noduri la momentul respectiv
	private classList list;
	private classVector vector ;
	private classSet set;
	/**
	 * Constructorul care creeaza instante la cele 3 structuri
	 * @param indice
	 */
	public nodA(int indice)
	{
		list = new classList();
		vector = new classVector();
		set = new classSet();
		this.indice = indice;
		
	}
	/**
	 * seteaza nume
	 */
	public void setName(String s)
	{
		this.Name = s;
	}
	/**
	 * seteaza indice
	 * @param indice indicele setat
	 */
	public void setIndice(int indice)
	{
		this.indice = indice;
	}
	/**
	 * Obtine numele
	 */
	public String getName()
	{
		return this.Name;
	}
	/**
	 * Seteaza id-ul
	 */
	public void setNumber(int number)
	{
		this.Number = number;
	}
	public int getNumber()
	{
		return this.Number;
	}
	/**
	 * Obtine id-ul
	 */
	public int getIndice()
	{
		return this.indice;
	}
	/**
	 * instanta noua la list
	 */
	public void set_list()
	{
		list = new classList();
	}
	/**
	 * instanta noua la vector
	 */
	public void set_vector()
	{
		vector = new classVector();
	}
	/**
	 * instanta noua la set
	 */
	public void set_set()
	{
		set = new classSet();
	}
	/**
	 * obtine lista
	 */
	public classList get_list()
	{
		return list;
	}
	/**
	 * obtine vectorul
	 */
	public classVector get_vector()
	{
		return vector;
	}
	/**
	 * obtine setul
	 */
	public classSet get_set()
	{
		return set;
	}
	/**
	 * creeaza muchie
	 */
	public void createMuchie(Nod nod2)
	{
		if(indice == 1)
			list.add(nod2); 
		if(indice == 2)
			vector.add(nod2);
		if(indice == 3)
			set.add(nod2);
		
	}
	
}
