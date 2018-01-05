/**
 * clasa nodB
 * @author root
 *
 */
  public class nodB extends Nod {
	private String Name;
	private int Number;
	private int indice; // 0,1,2-specifica versiunea de noduri la momentul respectiv
	private classList list ;
	private classVector vector ;
	private classSet set;
/**
 * Constructorul clasei
 * @param indice
 */
	public nodB(int indice)
	{
		
		list = new classList();
		vector = new classVector();
		set = new classSet();
		this.indice = indice;
	}
/**
 * Seteaza nume
 */
	public void setName(String s)
	{
		this.Name = s;
	}
/**
 * Seteaza indice
 * @param indice = indicele care trebuie setat
 */
	void setIndice(int indice)
	{
		this.indice = indice;
	}
/**
 * gather pentru nume
 */
	public String getName()
	{
		return this.Name;
	}
/**
 * Seter pentru number
 */
	public void setNumber(int number)
	{
		this.Number = number;
	}
/**
 * gather pentru number
 */
	public int getNumber()
	{
		return this.Number;
	}

/**
 * gather pentru indice 
 */
	public int getIndice()
	{
		return this.indice;
	}
/**
 * Creeaza instanta lista
 */
	public void set_list()
	{
		list = new classList();
	}
/**
 * creeaza instanta vector
 */
	public void set_vector()
	{
		vector = new classVector();
	}
/**
 * Creeaza instanta set
 */
	public void set_set()
	{
		set = new classSet();
	}
/**
 * retruneaza lista
 */
	public classList get_list()
	{
		return list;
	}
/**
 * Returneaza vector
 */
	public classVector get_vector()
	{
		return vector;
	}
/**
 * Returneaza set
 */
	public classSet get_set()
	{
		return set;
	}
/**
 *  creeaza muchie
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
