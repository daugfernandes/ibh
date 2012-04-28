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
    
    private Stack indentStack;
    private Stack nodeStack;
        
    private Node root;
    
    public Ibh() {
        this.root = new Node("\\", "root");
    }
    
    public boolean ImportFile(String pFileName) {
 
        try {
            FileInputStream fstream = new FileInputStream(pFileName);

            try (DataInputStream in = new DataInputStream(fstream)) {
                return ImportStream(in);
            }
        } catch (Exception e) { 
            return false;
        }
    }
    
    public boolean ImportStream(DataInputStream pIn) {
        
        indentStack = new Stack();
        nodeStack = new Stack();
        
        try{

            BufferedReader br = new BufferedReader(new InputStreamReader(pIn));
            String strLine;

            while ((strLine = br.readLine()) != null) {

                int indent = Strings.firstOccurenceOfNot(strLine, " ");
                int equalPosition = strLine.indexOf("=");

                String key = strLine;
                String value = "";

                if(equalPosition > -1) {
                    String[] aux = strLine.split("\\=");
                    key = aux[0].trim();
                    value = aux[1].trim();
                }

                // todo:

                indentStack.push(1);
            }
            
        }catch (Exception e){//Catch exception if any

            return false;
        
        }

        return true;
        
    }
    
    public Node getRoot() {
        return this.root;
    }
    
    // todo test
    public Node getNode(String pPath) {
        
        if(this.root == null)
            return null;
        
        Node ret = this.root;
        
        String[] keys = pPath.split("\\.");
        
        if(keys.length == 0)
            return this.root;
        
        for(int i = 0; i < keys.length; i++) {
            ret = ret.getNodeByKey(keys[i]);
            if(ret == null)
                return null;
        }
            
        return ret;
    }

    // todo test
    public Node getNodeCopy(String pPath) {
        return this.getNode(pPath).clone();
    }
    
}
