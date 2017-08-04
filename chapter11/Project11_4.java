/* Directions:
 * Write a rehash() method for the hash.java program. It should be called by 
 * insert() to move the entire hash table to an array about twice as large 
 * whenever the load factor exceeds 0.5. The new array size should be a prime 
 * number. Refer to the section “Expanding the Array” in this chapter. Don’t 
 * forget you’ll need to handle items that have been “deleted,” that is, written 
 * over with –1.
 */

package chapter11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Project11_4 {
	public static void main(String[] args) throws IOException {
		DataItem aDataItem;
		int aKey, size, n, keysPerCell;

		System.out.print("Enter size of hash table: ");
		size = getInt();

		System.out.print("Enter initial number of items: ");
		n = getInt();
		System.out.println();

		keysPerCell = 10;

		// Make table
		HashTable theHashTable = new HashTable(size);

		// Insert data
		for (int i = 0; i < n; i++) {
			aKey = (int) (Math.random() * keysPerCell * size);
			aDataItem = new DataItem(aKey);
			theHashTable.insert(aDataItem);
		}

		// Interact with user
		while (true) {
			System.out.print("Enter the first letter of show, insert, delete, or find: ");
			char choice = getChar();

			switch (choice) {
			case 's':
				theHashTable.display();
				break;
			case 'i':
				System.out.print("Enter key value to insert: ");
				aKey = getInt();
				aDataItem = new DataItem(aKey);
				theHashTable.insert(aDataItem);
				break;
			case 'd':
				System.out.print("Enter key value to delete: ");
				aKey = getInt();
				theHashTable.delete(aKey);
				break;
			case 'f':
				System.out.print("Enter key value to find: ");
				aKey = getInt();
				aDataItem = theHashTable.find(aKey);
				if (aDataItem != null) {
					System.out.println("Found " + aKey);
				} else
					System.out.println("Could not find " + aKey);
				break;
			default:
				System.out.print("Invalid entry\n");
			}
		}
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static char getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
}