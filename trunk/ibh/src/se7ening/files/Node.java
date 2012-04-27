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
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author David Fernandes <davidfernandes@acm.org>
 */
public class Node implements Cloneable {
    
    private String key;
    private String value;
    private List<Node> nodes;
    
    public Node(String pKey, String pValue) {
        this.key = pKey;
        this.value = pValue;
        this.nodes = new ArrayList<>();
    }
    
    public void addChildNode(Node pNode) {
        this.nodes.add(pNode);
    }
    
    public String getKey() {
        return this.key;
    }
    
    public void setKey(String pKey) {
        this.key = pKey;
    }
    
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String pValue) {
        this.value = pValue;
    }

    public List<Node> getNodes() {
        return this.nodes;
    }

    public void setNodes(List<Node> pNodes) {
        this.nodes = pNodes;
    }
    
    public Node getNodeByKey(String pKey) {
        Iterator it = this.nodes.iterator();
        while(it.hasNext()) {
            Node n =(Node)it.next();
            if(n.getKey().equals(pKey))
                return n;
        }
        return null;
    }
    
    @Override
    public Node clone()
    {
        try
    {
            return (Node)super.clone();
        }
    catch( CloneNotSupportedException e )
    {
            return null;
        }
    } 
    
}