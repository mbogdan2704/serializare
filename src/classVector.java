/**
 * clasa vector
 * @author root
 *
 */
public class classVector {
private int counter;
private int maxObjects;
 int exist;
Nod[] vector;
	/**
	 * Constructorul clasei fara paramentrii
	 */
 	public classVector()
	{
		vector = new Nod[100];
		this.maxObjects = 100;
	}
 	/**
 	 * Constructorul clasei cu un parametru
 	 * @param number numarul de elemente din vector
 	 */
	classVector(int number)
	{
		vector = new Nod[number];
		this.maxObjects = number;
	}
	/**
	 * incrementeaza counter
	 */
	public void incrementCounter()
	{
		counter ++;
	}
	/**
	 * decrementeaza counter
	 */
	public void decrementCounter()
	{
		counter --;
	}
	/**
	 * Adauga un element in vector
	 * @param o elementul adaugat
	 */
	public void add(Nod o)
	{
		
	
		this.realloc();
		vector[counter] = o;
		incrementCounter();
	}
	/**
	 * sterge un element din vector
	 * @param index index
	 */
	public void Remove(int index)
	{
		vector[index] = null;
	}
	/**
	 * returneaza un element din vector
	 * @param index indexul dorit
	 * @return
	 */
	public Nod get(int index)
	{
		return vector[index];
	}
	/**
	 * returneaza counter-ul
	 * @return
	 */
	public int getCounter()
	{
		return counter;
	}
	/**
	 * returneaza capacitatea
	 * @return
	 */
	public int capacity()
	{
		return counter;
	}
	/**
	 * sterge vectorul
	 */
	public void clear()
	{
		int i;
		for(i=0; i<= counter ;i++)
		{
			vector[i] = null;
		}
		counter = 0;
	}
	/**
	 * Realocare vector
	 */
	
	public void realloc()
	{
		if(this.counter  == this.maxObjects)
		{
			Object[] largerArray = new Object[counter *2];
			System.arraycopy(vector, 0, largerArray, 0, vector.length);
			vector = new Nod[counter*2];
			System.arraycopy(largerArray, 0, vector, 0, vector.length);
			largerArray = null;
			
		}
	}
	
}
