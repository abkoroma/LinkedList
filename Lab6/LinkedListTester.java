import java.io.PrintStream;
import java.util.Arrays;

public class LinkedListTester {
	public static int score;
	public static PrintStream out;
	public static PrintStream err;
	public static int testNumber;
	
public static void main(String[] args)
{
	score = 0;
	out = System.out;
	err = System.out;
	testNumber = 1;
	out.println("CORE");
	addTest(8);
	removeTest(8);
	clearTest(3);
	containsTest(5);
	getTest(5);
	indexOfTest(5);
	isEmptyTest(3);
	sizeTest(3);
	out.println("BONUS");
	//Uncomment these tests if you want to try running them, but they won't be worth any additional points for this lab.
	//iteratorTest(20);
	//subListTest(5);
	
	addAllTest(4);
	containsAllTest(4);
	lastIndexOfTest(2);
	removeAllTest(4);
	retainAllTest(4);
	setTest(2);
	toArrayTest(5);
	
	out.println("The below score assumes correct submission and that you obtained full style points.  Your actual score may be up to 20 points fewer.");
	out.println("Completed " + (testNumber-1) + " out of " + (testNumber-1) + " Tests for a total score of: 40 (no crashes) + 20 (submission and style) + " + score + " (from tests) = " + (60+score));
	}

public static int addTest(int pnts)
{
	String result = "[Banana, Apple, Durian, Banana, Carrot]";
	LinkedList<String> l = new LinkedList<String>();
	try {
	l.add("Banana");
	l.add("Apple");
	l.add("Banana");
	l.add("Carrot");
	l.add(2, "Durian");
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: addTest-");
		e.printStackTrace();
	}
	return eval(l, result, pnts, "add");
}

public static int iteratorTest(int pnts)
{
	String result = "[Banana, Apple, Banana, Carrot]";
	String comment = "";
	LinkedList<String> l = new LinkedList<String>();
	try {
		boolean correct = true;
	l.add("Banana");
	l.add("Apple");
	l.add("Banana");
	l.add("Carrot");
	String myString = "[";
	for(String s : l)
		myString += s + ", ";
	myString = myString.substring(0, myString.length() - 2) + "]";
	if(!myString.equals(result))
	{
	correct = false;
	comment = "When iterating, was expecting: " + result + " but got: " + myString;
	}
	return disp(correct, pnts, "iterator", comment);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: iteratorTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "iterator", comment);
}

public static int toArrayTest(int pnts)
{
	String comment = "";
	LinkedList<String> l = new LinkedList<String>();
	try {
		boolean correct = true;
	l.add("Banana");
	l.add("Apple");
	l.add("Banana");
	l.add("Carrot");
	String[] a0 = {"Banana", "Apple", "Banana", "Carrot"};
	String[] a2 = Arrays.copyOf(l.toArray(), l.size(), String[].class);
	//String[] a1 = (String[])(l.toArray(String[].class));
	
	for(int i = 0; i < 4; i++)
	{
		//if(!a1[i].equals(a0[i]))
		//{
		//	correct = false;
		//	comment = "toArray(String[]) failed - mismatch on index " + i + " Should have: " + a0[i] + " but got " + a1[i];
		//}
		if(!a2[i].equals(a0[i]))
		{
			correct = false;
			comment = "toArray() failed - mismatch on index " + i + " Should have: " + a0[i] + " but got " + a2[i];
		}
	}
	
	return disp(correct, pnts, "toArray", comment);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: toArrayTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "toArray", comment);
}

public static int subListTest(int pnts)
{
	String result = "[Apple, Banana]";
	LinkedList<String> l = new LinkedList<String>();
	LinkedList<String> l2 = new LinkedList<String>();
	try {
	l.add("Banana");
	l.add("Apple");
	l.add("Banana");
	l.add("Carrot");
	l2 = (LinkedList<String>) l.subList(1, 3);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: subListTest-");
		e.printStackTrace();
	}
	return eval(l2, result, pnts, "subList");
}

public static int setTest(int pnts)
{
	String result = "[Banana, Apple, Durian, Carrot]";
	LinkedList<String> l = new LinkedList<String>();
	try {
	l.add("Banana");
	l.add("Apple");
	l.add("Banana");
	l.add("Carrot");
	l.set(2, "Durian");
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: setTest-");
		e.printStackTrace();
	}
	return eval(l, result, pnts, "set");
}

public static int retainAllTest(int pnts)
{
	String result = "[Banana, Banana, Carrot]";
	LinkedList<String> l = new LinkedList<String>();
	LinkedList<String> l2 = new LinkedList<String>();
	try {
	l.add("Banana");
	l.add("Apple");
	l.add("Banana");
	l.add("Carrot");
	l2.add("Carrot");
	l2.add("Banana");
	l2.add("Eggplant");
	l.retainAll(l2);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: retainAllTest-");
		e.printStackTrace();
	}
	return eval(l, result, pnts, "retainAll");
}

public static int removeAllTest(int pnts)
{
	String result = "[Banana, Apple, Banana]";
	LinkedList<String> l = new LinkedList<String>();
	LinkedList<String> l2 = new LinkedList<String>();
	try {
	l.add("Banana");
	l.add("Apple");
	l.add("Banana");
	l.add("Carrot");
	l2.add("Carrot");
	l2.add("Eggplant");
	l.removeAll(l2);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: removeAllTest-");
		e.printStackTrace();
	}
	return eval(l, result, pnts, "removeAll");
}

public static int removeTest(int pnts)
{
	String result = "[Apple, Banana]";
	LinkedList<String> l = new LinkedList<String>();
	try {
	l.add("Banana");
	l.add("Apple");
	l.add("Banana");
	l.add("Carrot");
	l.remove("Banana");
	l.remove(2);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: removeTest-");
		e.printStackTrace();
	}
	return eval(l, result, pnts, "remove");
}

public static int getTest(int pnts)
{
	String comment = "";
	LinkedList<String> l = new LinkedList<String>();
	try {
		boolean correct = true;
	l.add("Banana");
	l.add("Apple");
	l.add("Banana");
	l.add("Carrot");
	if(!l.get(1).contentEquals("Apple"))
	{
	correct = false;
	comment = "Got " + l.get(1) + " when should have got Apple";
	}
	return disp(correct, pnts, "get", comment);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: getTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "get", comment);
}

public static int isEmptyTest(int pnts)
{
	String comment = "";
	LinkedList<String> l = new LinkedList<String>();
	try {
		boolean correct = true;
		if(!l.isEmpty())
		{
			correct = false;
			comment = "New list isn't empty";
		}
	l.add("Banana");
		if(l.isEmpty())
		{
			correct = false;
			comment = "Filled list is empty";
		}
		l.clear();
		if(!l.isEmpty())
		{
			correct = false;
			comment = "Cleared list isn't empty";
		}
	return disp(correct, pnts, "isEmpty", comment);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: isEmptyTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "isEmpty", comment);
}

public static int lastIndexOfTest(int pnts)
{
	String comment = "";
	LinkedList<String> l = new LinkedList<String>();
	try {
		boolean correct = true;
	l.add("Banana");
	l.add("Apple");
	l.add("Banana");
	l.add("Carrot");
	if(!(l.lastIndexOf("Apple") == 1))
	{
	correct = false;
	comment = "Apple was not at index 1";
	}
	if(!(l.lastIndexOf("Eggplant") == -1))
	{
		correct = false;
		comment = "Eggplant (not in list) is not at index -1";
	}
	if(!(l.lastIndexOf("Banana") == 2))
	{
		correct = false;
		comment = "Last index of Banana not at 2";
	}
	return disp(correct, pnts, "lastIndexOf", comment);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: lastIndexOfTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "lastIndexOf", comment);
}

public static int sizeTest(int pnts)
{
	String comment = "";
	LinkedList<String> l = new LinkedList<String>();
	try {
		boolean correct = true;
	l.add("Banana");
	l.add("Apple");
	l.add("Banana");
	l.add("Carrot");
	if(!(l.size() == 4))
	{
	correct = false;
	comment = "List of size 4 says it has a size of " + l.size();
	}
	return disp(correct, pnts, "size", comment);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: sizeTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "size", comment);
}

public static int indexOfTest(int pnts)
{
	String comment = "";
	LinkedList<String> l = new LinkedList<String>();
	try {
		boolean correct = true;
	l.add("Banana");
	l.add("Apple");
	l.add("Banana");
	l.add("Carrot");
	if(!(l.indexOf("Apple") == 1))
	{
	correct = false;
	comment = "Apple was not at index 1";
	}
	if(!(l.indexOf("Eggplant") == -1))
	{
		correct = false;
		comment = "Eggplant (not in list) is not at index -1";
	}
	if(!(l.indexOf("Banana") == 0))
	{
	correct = false;
	comment = "First index of Banana not at 0";
	}
	return disp(correct, pnts, "indexOf", comment);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: indexOfTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "indexOf", comment);
}

public static int containsTest(int pnts)
{
	String comment = "";
	LinkedList<String> l = new LinkedList<String>();
	try {
		boolean correct = true;
	l.add("Apple");
	l.add("Banana");
	l.add("Carrot");
	l.add("Durian");
	if(!l.contains("Carrot"))
	{
		correct = false;
		comment = "False negative";
	}
	if(l.contains("Eggplant"))
	{
		correct = false;
		comment = "False positive";
	}
	return disp(correct, pnts, "contains", comment);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: containsTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "contains", comment);
}

public static int containsAllTest(int pnts)
{
	String comment = "";
	LinkedList<String> l = new LinkedList<String>();
	LinkedList<String> l2 = new LinkedList<String>();
	LinkedList<String> l3 = new LinkedList<String>();
	try {
		boolean correct = true;
	l.add("Apple");
	l.add("Banana");
	l.add("Carrot");
	l.add("Durian");
	l2.add("Banana");
	l2.add("Carrot");
	l3.add("Banana");
	l3.add("Eggplant");
	if(!l.containsAll(l2))
	{
		correct = false;
		comment = "False negative";
	}
	if(l.containsAll(l3))
	{
		correct = false;
		comment = "False positive";
	}
	return disp(correct, pnts, "containsAll", comment);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: containsAllTest-");
		e.printStackTrace();
	}
	return disp(false, pnts, "containsAll", comment);
}

public static int clearTest(int pnts)
{
	String result = "[Carrot]";
	LinkedList<String> l = new LinkedList<String>();
	try {
	l.add("Banana");
	l.add("Apple");
	l.clear();
	l.add("Carrot");
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: clearTest-");
		e.printStackTrace();
	}
	return eval(l, result, pnts, "clear");
}

public static int addAllTest(int pnts)
{
	String result = "[Potato, Potato, Celery, Lettuce, Celery, Lettuce]";
	LinkedList<String> addList = new LinkedList<String>();
	LinkedList<String> l = new LinkedList<String>();
	try {
		addList.add("Potato");
		addList.add("Celery");
		addList.add("Lettuce");
		l.addAll(addList);
		l.addAll(1, addList);
	}
	catch(Exception e)
	{
		err.println("-ERROR IN: addAllTest-");
		e.printStackTrace();
	}
	return eval(l, result, pnts, "addAll");
}

public static int eval(LinkedList l, String result, int pnts, String test)
{
	testNumber++;
	try {
	boolean equal = result.equals(l.toString());
	String output = "TEST " + (testNumber-1) + ") " + test + " -> ";
	if(!equal)
		output += ">>>FAILURE<<< (" + "0/" + pnts + ")";
	else
		output += "---SUCCESS--- (" + pnts + "/" + pnts + ")";
	output += " EXPECTED: \"" + result + "\" == YOURS: \"" + l + "\"  ";
	out.println(output);
	if(equal)
	{
		score += pnts;
		return pnts;
	}
	else
		return 0;
	}
	catch(Exception e) {
		out.println("TEST " + (testNumber-1) + ") " + test + " -> " + ">>>FAILURE<<< (0/" + pnts + ") Error in evaluating String");
		return 0;
	}
}

public static int disp(boolean equal, int pnts, String test, String comment) {
	String output = "TEST " + testNumber + ") " + test + " -> ";
	if(!equal)
		output += ">>>FAILURE<<< (" + "0/" + pnts + ")";
	else
		output += "---SUCCESS--- (" + pnts + "/" + pnts + ")";
	output += " " + comment;
	out.println(output);
	testNumber++;
	if(equal)
	{
		score += pnts;
		return pnts;
	}
	else
		return 0;
}

}