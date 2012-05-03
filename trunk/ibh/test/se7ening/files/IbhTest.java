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

import java.io.*;
import static org.junit.Assert.assertEquals;
import org.junit.*;
import se7ening.utilities.Node;

/**
 *
 * @author David Fernandes <davidfernandes@acm.org>
 */
public class IbhTest {
    
    /**
     * 
     */
    public IbhTest() {
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
     * Test of parseFile method, of class Ibh.
     * @throws IOException 
     */
    @Test
    public void testParseFile() throws IOException {
        System.out.println("testParseFile");
        Ibh instance = new Ibh();
        instance.parseFile(createTempFile());
        String expResult = "\\=root- a=0-  a1=1-  a2=2-   a21=21-    a211=211-    a212=212-   a22=22-  a3=3-   a31=31- b=33-  b1=1-   b11=11-    b111=111- c=4- d=33-  b1=1-   b11=11-   b12=12- e=4-";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    private String createTempFile() throws IOException {
        File tempFile = File.createTempFile("teste", ".ibh" );
        try (Writer out = new OutputStreamWriter(new FileOutputStream(tempFile.getAbsolutePath()), "UTF-8")) {
            System.out.println(tempFile.getAbsolutePath());
            out.write("# test file\n");
            out.write("a=0\n");
            out.write("   a1=1\n");
            out.write("   a2=2\n");
            out.write("      a21=21\n");
            out.write("         a211=211\n");
            out.write("         a212=212\n");
            out.write("      a22=22\n");
            out.write("   a3=3\n");
            out.write("      a31=31\n");
            out.write("b=33\n");
            out.write("   b1=1\n");
            out.write("      b11=11\n");
            out.write("          b111=111\n");
            out.write("c=4\n");
            out.write("\n");
            out.write("   \n");
            out.write("   # teste\n");
            out.write("d=33\n");
            out.write("   b1=1\n");
            out.write("      b11=11\n");
            out.write("      b12=12\n");
            out.write("e=4                \n");
            out.close();
        }
        
        return tempFile.getAbsolutePath();
    }
    
    /**
     * Test of toString method, of class Ibh.
     * @throws IOException 
     */
    @Test
    public void testToString() throws IOException {
        System.out.println("toString");
        Ibh instance = new Ibh();
        instance.parseFile(createTempFile());
        String expResult = "\\=root- a=0-  a1=1-  a2=2-   a21=21-    a211=211-    a212=212-   a22=22-  a3=3-   a31=31- b=33-  b1=1-   b11=11-    b111=111- c=4- d=33-  b1=1-   b11=11-   b12=12- e=4-";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of parseStream method, of class Ibh.
     * @throws IOException 
     */
    @Test
    public void testParseStream() throws IOException {
        System.out.println("testParseStream");
        Ibh instance = new Ibh();
        
         try {
            FileInputStream fstream = new FileInputStream(createTempFile());

            try (DataInputStream in = new DataInputStream(fstream)) {
                instance.parseStream(in);
            }
        } catch (Exception e) { 
        }
        
        String expResult = "\\=root- a=0-  a1=1-  a2=2-   a21=21-    a211=211-    a212=212-   a22=22-  a3=3-   a31=31- b=33-  b1=1-   b11=11-    b111=111- c=4- d=33-  b1=1-   b11=11-   b12=12- e=4-";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoot method, of class Ibh.
     */
    @Test
    public void testGetRoot() {
        System.out.println("getRoot");
        Ibh instance = new Ibh();
        Node result = instance.getRoot();
        assertEquals("root", result.getValue());
        assertEquals("\\", result.getKey());
    }

    /**
     * Test of getNode method, of class Ibh.
     * @throws IOException 
     */
    @Test
    public void testGetNode() throws IOException {
        System.out.println("getNode");
        String pPath = "";
        Ibh instance = new Ibh();
        instance.parseFile(createTempFile());
        String expResult = "211";
        Node result = instance.getNode("a.a2.a21.a211");
        assertEquals(expResult, result.getValue());
    }

    /**
     * Test of getNodeCopy method, of class Ibh.
     * @throws IOException 
     */
    @Test
    public void testGetNodeCopy() throws IOException {
        System.out.println("getNodeCopy");
        Ibh instance = new Ibh();
        instance.parseFile(createTempFile());

        // for test, changes properties of the new cloned node
        Node result = instance.getNodeCopy("a.a2.a21");
        result.setKey("a-21");
        result.setValue("a2121");
        assertEquals(result.getKey(), "a-21");
        assertEquals(result.getValue(), "a2121");
        
        // and certifies that the original node stays inaltered
        Node node1 = instance.getNode("a.a2.a21");
        assertEquals(node1.getKey(), "a21");
        assertEquals(node1.getValue(), "21");
    }
}
