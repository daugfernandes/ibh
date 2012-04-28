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

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author David Fernandes <davidfernandes@acm.org>
 */
public class NodeTest {
    
    public NodeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addChildNode method, of class Node.
     */
    @Test
    public void testAddChildNode() {
        System.out.println("addChildNode");
        Node pNode = null;
        Node instance = null;
        instance.addChildNode(pNode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKey method, of class Node.
     */
    @Test
    public void testGetKey() {
        System.out.println("getKey");
        Node instance = null;
        String expResult = "";
        String result = instance.getKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParent method, of class Node.
     */
    @Test
    public void testSetParent() {
        System.out.println("setParent");
        Node pNode = null;
        Node instance = null;
        instance.setParent(pNode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKey method, of class Node.
     */
    @Test
    public void testSetKey() {
        System.out.println("setKey");
        String pKey = "";
        Node instance = null;
        instance.setKey(pKey);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class Node.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Node instance = null;
        String expResult = "";
        String result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class Node.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        String pValue = "";
        Node instance = null;
        instance.setValue(pValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNodes method, of class Node.
     */
    @Test
    public void testGetNodes() {
        System.out.println("getNodes");
        Node instance = null;
        List expResult = null;
        List result = instance.getNodes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNodes method, of class Node.
     */
    @Test
    public void testSetNodes() {
        System.out.println("setNodes");
        List<Node> pNodes = null;
        Node instance = null;
        instance.setNodes(pNodes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNodeByKey method, of class Node.
     */
    @Test
    public void testGetNodeByKey() {
        System.out.println("getNodeByKey");
        String pKey = "";
        Node instance = null;
        Node expResult = null;
        Node result = instance.getNodeByKey(pKey);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Node.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Node instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toStringAux method, of class Node.
     */
    @Test
    public void testToStringAux() {
        System.out.println("toStringAux");
        String pPrefix = "";
        Node instance = null;
        String expResult = "";
        String result = instance.toStringAux(pPrefix);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class Node.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        Node instance = null;
        Node expResult = null;
        Node result = instance.clone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
