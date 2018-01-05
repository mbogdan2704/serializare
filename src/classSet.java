/**
 * Clasa set
 * @author root
 *
 */
public class classSet {
	nodeSet head;
	int counter;
	Nod o = null;
	classSet(){}
	/**
	 * Adauga un element in set
	 * @param data elementul care trebuie adaugat
	 */
	public void add(Nod data)
	{


		if(head != null)
		{

			incrementCounter();
			nodeSet temp = new nodeSet(data);
			nodeSet current = head;
			if(current != null)
			{

				while(true)
				{
					if(current.getData().hashCode() == temp.getData().hashCode())
						break;
					if(current.getLeft() == null && current.getData().hashCode() > temp.getData().hashCode())
					{
						current.setLeft(temp,this.counter);  break;
					}
					if(current.getRight() == null && current.getData().hashCode() < temp.getData().hashCode())
					{
						current.setRight(temp,this.counter);  break;
					}
					if(current.getLeft() != null && current.getData().hashCode() > temp.getData().hashCode())
					{
						current = current.getLeft();
					}
					if(current.getRight() != null && current.getData().hashCode() < temp.getData().hashCode())
					{
						current = current.getRight();
					}
				}	

			}
		}
		else
			head = new nodeSet(data);
	}
	/**
	 * Returneaza un element din set cu indexul i
	 * @param index indexul dorit
	 * @return
	 */
	public Nod get(int index)
	{
		nodeSet current = head;
		function2(current,index,0);
		return o;
	}
	/**
	 * Returneaza numarul de elemente din set
	 * @return
	 */
	public int getCounter()
	{
		return counter;
	}
	/**
	 * Incrementeaza counter-ul
	 */
	public void incrementCounter()
	{
		counter ++;
	}

	/**
	 * Sterge un element din set
	 * @param index index
	 */
	public void Remove(int index)
	{
		nodeSet current = head;
		removeAux(current,index);
	}
	
	/**
	 * functie auxiliara pentru remove
	 * @param current elementul curent
	 * @param index index
	 */
	public void removeAux(nodeSet current, int index)
	{
		if(current.getNumber() == index)
		{
			current.setExista();
		}
		if(current.getLeft() != null)
			removeAux(current.getLeft(),index);
		if(current.getRight() != null)
			removeAux(current.getRight(),index);
	}
	/**
	 * Functie auxiliara pentru get
	 * @param current elementul curent
	 * @param index indexul
	 * @param inc increment
	 */


	public void function2(nodeSet current,int index,int inc)
	{

		if(current != null)
		{
			if(current.getNumber() == index)
			{
			if(current.getExista() == 0)
				o = current.getData();
			else
				o = null;
			}

		}
		if(current != null)
		{
			if(current.getLeft() != null)
				function2(current.getLeft(),index,++inc);
			if(current.getRight() != null)
				function2(current.getRight(),index,++inc);
		}

	}
}

