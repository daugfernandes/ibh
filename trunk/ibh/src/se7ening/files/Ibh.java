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

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import se7ening.utilities.Node;
import se7ening.utilities.Strings;

/**
 * Indent-based hierarchy
 * @author David Fernandes <david.paiva.fernandes@gmail.com>
 */
public class Ibh {
        
    private Node root;
    
    /**
     * Indent-based hierarchy class
     */
    public Ibh() {
        this.root = new Node("\\", "root");
    }
    
    /**
     * Parse a text file
     * @param pFileName Complete file name
     * @return Completeness of the parsing process (true/false).
     */
    public boolean parseFile(String pFileName) {
 
        try {
            FileInputStream fstream = new FileInputStream(pFileName);

            try (DataInputStream in = new DataInputStream(fstream)) {
                return parseStream(in);
            }
        } catch (Exception e) { 
            return false;
        }
    }
    
    /**
     * Parse a stream
     * @param pIn Input stream
     * @return Completeness of the parsing process (true/false).
     */
    public boolean parseStream(DataInputStream pIn) {
        
        Integer tabChars = 0;

        HashMap attributes = new HashMap();
        
        Stack<Integer> indentStack = new Stack<>();
        Stack<Node> nodeStack = new Stack<>();
        
        indentStack.push(-1);
        nodeStack.push(this.root);
        
        try{

            BufferedReader br = new BufferedReader(new InputStreamReader(pIn));
            String strLine;
            
            while ((strLine = br.readLine()) != null) {

                // treat attributes as, for example
                // tab length:  
                // % tab 4
                if(strLine.trim().startsWith("%")) {
                    String[] aux = strLine.trim().replaceAll("  ", " ").split(" ");
                    attributes.put(aux[1], aux.length>1 ? aux[2] : "");
                }
                
                else
                
                    if(strLine.trim().length() > 0 && !strLine.trim().startsWith("#")) {

                        if(attributes.containsKey("tab"))
                            strLine = strLine.replace("\t", new String(new char[Integer.parseInt((String)attributes.get("tab"))]).replace("\0", " "));

                        Integer indent = Strings.firstOccurenceOfNot(strLine, " ");

                        String[] aux = strLine.split("\\=");
                        String key = aux[0].trim();
                        String value = "";

                        for(int i=1; i<aux.length; i++)
                        {
                            if(i>1) value += "=";
                            value += aux[i].trim();
                        }

                        Node newNode = new Node(key, value);

                        while(indent < (int)indentStack.peek()) {
                            indentStack.pop();
                            nodeStack.pop();
                        } 

                        if(indent > (int)indentStack.peek()) {
                            ((Node)nodeStack.peek()).addChildNode(newNode);
                            nodeStack.push(newNode);
                            indentStack.push(indent);
                        } else { // indent == (int)indentStack.peek()
                            // no need to pop (or push) indentStack as the 
                            // identation is the same as previous line
                            nodeStack.pop();
                            ((Node)nodeStack.peek()).addChildNode(newNode);
                            nodeStack.push(newNode);
                        }
                    }
            }
            
        }catch (Exception e){//Catch exception if any

            return false;
        
        }

        return true;
        
    }
    
    /**
     * 
     * @return Root node
     */
    public Node getRoot() {
        return this.root;
    }
    
    // todo test
    /**
     * Get a Node based on the its path
     * @param pPath Complete path dot-separated string
     * @return Node
     */
    public Node getNode(String pPath) {
        
        if(this.root == null)
            return null;
        
        Node ret = this.root;
        
        String[] keys = pPath.split("\\.");
        
        if(keys.length == 0)
            return this.root;
        
        for(Integer i = 0; i < keys.length; i++) {
            ret = ret.getNodeByKey(keys[i]);
            if(ret == null)
                return null;
        }
            
        return ret;
    }

    /**
     * Clones a node
     * @param pPath
     * @return A new cloned node
     */
    public Node getNodeCopy(String pPath) {
        return this.getNode(pPath).clone();
    }
    
    /**
     * String representation
     * @return A string
     */
    @Override
    public String toString() {
        return this.root.toString();
    }
    
    
}
