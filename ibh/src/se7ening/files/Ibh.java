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
import java.util.Stack;
import se7ening.utilities.Strings;

/**
 *
 * @author David Fernandes <davidfernandes@acm.org>
 */
public class Ibh {
        
    private Node root;
    
    /**
     * Parameterless constructor
     * Creates only the root node.
     */
    public Ibh() {
        this.root = new Node("\\", "root");
    }
    
    /**
     * Parse a indent-based text file
     * @param pFileName Complete name of the text file to parse (read access only).
     * @return Completeness of the parsing process (true/false).
     */
    public boolean ParseFile(String pFileName) {
 
        try {
            FileInputStream fstream = new FileInputStream(pFileName);

            try (DataInputStream in = new DataInputStream(fstream)) {
                return ParseStream(in);
            }
        } catch (Exception e) { 
            return false;
        }
    }
    
    /**
     * 
     * @return
     */
    @Override
    public String toString() {
        return this.root.toString();
    }
    
    /**
     * 
     * @param pIn
     * @return
     */
    public boolean ParseStream(DataInputStream pIn) {
        
        Stack<Integer> indentStack = new Stack<>();
        Stack<Node> nodeStack = new Stack<>();
        
        indentStack.push(-1);
        nodeStack.push(this.root);
        
        try{

            BufferedReader br = new BufferedReader(new InputStreamReader(pIn));
            String strLine;
            
            while ((strLine = br.readLine()) != null) {

                if(strLine.trim().length() > 0 && !strLine.trim().startsWith("#")) {
                
                    Integer indent = Strings.firstOccurenceOfNot(strLine, " ");

                    String[] aux = strLine.split("\\=");
                    String key = aux[0].trim();
                    String value = "";

                    if(aux.length > 1) value = aux[1].trim();

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
     * @return
     */
    public Node getRoot() {
        return this.root;
    }
    
    // todo test
    /**
     * 
     * @param pPath
     * @return
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

    // todo test
    /**
     * 
     * @param pPath
     * @return
     */
    public Node getNodeCopy(String pPath) {
        return this.getNode(pPath).clone();
    }
    
}
