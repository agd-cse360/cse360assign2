package cse360assign2;

/**
 * Adam David, ID: 1206458990
 * Class:  CSE 360, Fall 2019, Class #: 70641
 *
 * This file contains the implementation of an
 * adding machine that can be used to add and
 * subtract numbers from a total while preserving
 * the history of the transactions.
 */

import java.util.ArrayList;

/**
 * The <code>AddingMachine</code> class can be used to add and subtract a
 * running total of numbers. The total can be obtained at any time, and if
 * desired, the history of the transactions can be obtained as a string.
 */

public class AddingMachine {
	// We store the running total in this member.
	private int totalValue;

	// We use this to store the history of the values.
	private ArrayList<Integer> valueHistory = new ArrayList<Integer>();
	// We use this to store the history of the operations sent to the machine.
	private ArrayList<Character> operatorHistory = new ArrayList<Character>();

	/**
	 * This method creates an AddingMachine object with its total value initialized
	 * to 0.
	 */
	public AddingMachine() {
		totalValue = 0;
		valueHistory.add(0);
	}

	/**
	 * This method adds the parameter <code>numToAdd</code> to the total value of
	 * the machine.
	 * 
	 * @param numToAdd The number to be added.
	 */
	public void add(int numToAdd) {
		totalValue = totalValue + numToAdd;
		valueHistory.add(numToAdd);
		operatorHistory.add('+');
	}

	/**
	 * This method subtracts the parameter <code>numToSubtract</code> from the total
	 * value of the machine.
	 * 
	 * @param numToSubtract The number to subtract.
	 */
	public void subtract(int numToSubtract) {
		totalValue = totalValue - numToSubtract;
		valueHistory.add(numToSubtract);
		operatorHistory.add('-');
	}

	/**
	 * This method returns the current value of the machine.
	 * 
	 * @return The current total value of the machine.
	 */
	public int getTotal() {
		return totalValue;
	}

	/**
	 * This method returns the history of the transactions the machine has received
	 * as a string.
	 * 
	 * @return A string with the numbers and operations the machine has received.
	 */
	public String toString() {
		String history = new String();
		
		int historyIndex = 0;
		while (historyIndex < valueHistory.size()) {
			history += Integer.toString(valueHistory.get(historyIndex));
			
			//We only print a space afterwards if we're not on the last
			//number in valueHistory
			if (historyIndex != valueHistory.size() - 1) {
				history += " ";
			}
			
			//Because we store 0 in valueHistory, we're going to have
			//one less operation than we have values.
			if (historyIndex < operatorHistory.size()) {
				history = history + operatorHistory.get(historyIndex);
				history += " ";
			}
			
			historyIndex++;
		}
		
		return history;
	}
}
