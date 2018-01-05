/**
 * clasa C
 * @author root
 *
 */
  public class nodC extends Nod{
	private String Name;
	private int Number;
	private int indice; // 0,1,2-specifica versiunea de noduri la momentul respectiv
	private classList list;
	private classVector vector ;
	private classSet set;
	/**
	 * Constructorul clasei care creeaza instantele
	 * @param indice stabileste versiunea
	 */
	public nodC(int indice)
	{
		list = new classList();
		vector = new classVector();
		set = new classSet();
		this.indice = indice;
	}
	/**
	 * ster nume
	 */
	public void setName(String s)
	{
		this.Name = s;
	}
	/**
	 * seteaza lista
	 */
	public void set_list()
	{
		list = new classList();
	}
	/**
	 * seteaza vector
	 */
	public void set_vector()
	{
		vector = new classVector();
	}
	/**
	 * seteaza set
	 */
	public void set_set()
	{
		set = new classSet();
	}
	/**
	 * returneaza lista
	 */
	classList get_list()
	{
		return list;
	}
	/**
	 * returneaza vector
	 */
	classVector get_vector()
	{
		return vector;
	}
	/**
	 * seter indice
	 * @param indice indice
	 */
	public void setIndice(int indice)
	{
		this.indice = indice;
	}
	/**
	 * returneaza set
	 */
	classSet get_set()
	{
		return set;
	}
	/**
	 * returneaza nume
	 */
	String getName()
	{
		return this.Name;
	}
	/**
	 * seteaza number
	 */
	public void setNumber(int number)
	{
		this.Number = number;
	}
	/**
	 * gather number
	 */
	int getNumber()
	{
		return this.Number;
	}
	/**
	 * gather indice
	 */
	int getIndice()
	{
		return this.indice;
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
