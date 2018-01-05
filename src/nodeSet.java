/**
 * Clasa pentru nodurile set-ului
 * @author root
 *
 */
public class nodeSet {
nodeSet left,right;
Nod data;
int number;
int exist;
/**
 * seteaza data intr-un nod
 * @param dataValue data
 */
public nodeSet(Nod dataValue)
{
	left = null;
	right = null;
	this.data =dataValue;
}
/**
 * Seteaza nodul din stanga
 * @param leftValue nodul din stanga
 * @param counter seteaza indicele
 */
public void setLeft(nodeSet leftValue,int counter)
{
	left = leftValue;
	leftValue.number = counter;
}
/**
 * Seteaza faptul ca nodul nu mai eista(dupa stergere pun 1 ca sa stiu ca a fost sters)
 */
public void setExista()
{
	this.exist = 1;
}
/**
 * Returneaza variabial exist
 * @return
 */
public int getExista()
{
	return this.exist;
}
/**
 * seteaza nodul din dreapta
 * @param rightValue nodul din dreapta
 * @param counter seteaza indice
 */
public void setRight(nodeSet rightValue,int counter)
{
	right = rightValue;
	rightValue.number = counter;
}
/**
 * Pune data
 * @param value valoare
 */
public void set(Nod value)
{
	data = value;
}
/**
 * Obtine data stanga
 * @return
 */
public nodeSet getLeft()
{
	return left;
}
/**
 * Obtine data dreapta
 * @return
 */
public nodeSet getRight()
{
	return right;
}
/**
 * Obtine indice
 * @return
 */
public int getNumber()
{
	return number;
}
/**
 * Obtine data
 * @return
 */
public Nod getData() {
	return data;
}
}
