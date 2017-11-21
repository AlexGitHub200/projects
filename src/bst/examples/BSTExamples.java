/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst.examples;

import com.google.common.base.Strings;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author alex
 */
public class BSTExamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        BinarySearchTree b = new BinarySearchTree();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println("Original Tree : ");
                
                List<String> myList =
    Arrays.asList("a1", "a2", "b1", "c2", "c1");
    
     System.out.println(Strings.isNullOrEmpty(""));
                

myList
    .stream()
    .filter(s -> s.startsWith("c"))
    .map(String::toUpperCase)
    .sorted()
    .forEach(System.out::println);
        
    }
    
}
