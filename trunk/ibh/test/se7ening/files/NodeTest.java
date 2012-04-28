/*
 * Copyright (C) 2012 David Fernandes <davidfernandes@acm.org>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package se7ening.files;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.*;

/**
 *
 * @author David Fernandes <davidfernandes@acm.org>
 */
public class NodeTest {
    
    /**
     * 
     */
    public NodeTest() {
    }

    /**
     * 
     * @throws Exception
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    /**
     * 
     * @throws Exception
     */
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    /**
     * 
     */
    @Before
    public void setUp() {
    }
    
    /**
     * 
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of addChildNode method, of class Node.
     */
    @Test
    public void testAddChildNode() {
        System.out.println("addChildNode");
        Node pNode = new Node("a", "a1");
        Node instance = new Node("b", "b1");
        instance.addChildNode(pNode);
        assertEquals(instance.getNodes().get(0).toString(), pNode.toString());
    }

    /**
     * Test of getKey method, of class Node.
     */
    @Test
    public void testGetKey() {
        System.out.println("getKey");
        Node instance = new Node("a","aaa111");
        String expResult = "a";
        String result = instance.getKey();
        assertEquals(expResult, result);
    }

    /**
     * Test of setParent method, of class Node.
     */
    @Test
    public void testSetParent() {
        System.out.println("setParent");
        Node pNode = new Node("a","a1");
        Node instance = new Node("b","b1");
        instance.setParent(pNode);
        assertEquals(instance.getParent().getKey(), "a");
        assertEquals(instance.getParent().getValue(), "a1");
        assertEquals(instance.getKey(), "b");
        assertEquals(instance.getValue(), "b1");
    }

    /**
     * Test of setKey method, of class Node.
     */
    @Test
    public void testSetKey() {
        System.out.println("setKey");
        String pKey = "bb";
        Node instance = new Node("a", "a1");
        instance.setKey(pKey);
        assertEquals(pKey, instance.getKey());
    }

    /**
     * Test of getValue method, of class Node.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Node instance = new Node("a", "aaaawefgweg");
        String expResult = "aaaawefgweg";
        String result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class Node.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        String pValue = "asfkjlghsdfkljgh";
        Node instance = new Node("a", "a");
        instance.setValue(pValue);
        assertEquals(pValue, instance.getValue());
    }

    /**
     * Test of getNodes method, of class Node.
     */
    @Test
    public void testGetNodes() {
        System.out.println("getNodes");
        Node instance = new Node("a", "a1");
        Node node1 = new Node("b", "b1");
        Node node2 = new Node("c", "c1");
        Node node3 = new Node("d", "d1");
        
        List<Node> expResult = new ArrayList<>();
        expResult.add(node1);
        expResult.add(node2);
        expResult.add(node3);
                
        instance.addChildNode(node1);
        instance.addChildNode(node2);
        instance.addChildNode(node3);
        
        List result = instance.getNodes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNodes method, of class Node.
     */
    @Test
    public void testSetNodes() {
        System.out.println("setNodes");

        Node instance = new Node("a", "a1");
        Node node1 = new Node("b", "b1");
        Node node2 = new Node("c", "c1");
        Node node3 = new Node("d", "d1");
        
        List<Node> expResult = new ArrayList<>();
        expResult.add(node1);
        expResult.add(node2);
        expResult.add(node3);
                
        instance.setNodes(expResult);
        List<Node> expResult2 = instance.getNodes();
        assertEquals(expResult, expResult2);
    }

    /**
     * Test of getNodeByKey method, of class Node.
     */
    @Test
    public void testGetNodeByKey() {
        System.out.println("getNodeByKey");
        String pKey = "b";
        Node instance = new Node("a", "a1");
        instance.addChildNode(new Node("b", "b1"));
        Node result = instance.getNodeByKey(pKey);
        assertEquals("b", result.getKey());
    }

    /**
     * Test of toString method, of class Node.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Node instance = new Node("a", "a1");
        String expResult = "a=a1-";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toStringAux method, of class Node.
     */
    @Test
    public void testToStringAux() {
        System.out.println("toStringAux");
        String pPrefix = "x";
        Node instance = new Node("a", "a1");
        String expResult = "xa=a1-";
        String result = instance.toStringAux(pPrefix);
        assertEquals(expResult, result);
    }

    /**
     * Test of clone method, of class Node.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        Node instance = new Node("a","a1");
        Node expResult = new Node("a", "a1");
        Node result = instance.clone();
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of getParent method, of class Node.
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");
        Node pNode = new Node("a", "a1");
        Node instance = new Node("b", "b1");
        instance.setParent(pNode);
        assertEquals(instance.getParent().toString(), pNode.toString());
    }
}
