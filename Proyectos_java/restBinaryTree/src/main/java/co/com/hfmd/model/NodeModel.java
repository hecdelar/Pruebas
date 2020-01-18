package co.com.hfmd.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NodeModel {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("value")
    private Integer value;
	
	@JsonProperty("left")
    private NodeModel left;
	
	@JsonProperty("right")
    private NodeModel right;
 
    //public NodeModel(Integer value) {
    //    this.value = value;
    //}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public NodeModel getLeft() {
		return left;
	}

	public void setLeft(NodeModel left) {
		this.left = left;
	}

	public NodeModel getRight() {
		return right;
	}

	public void setRight(NodeModel right) {
		this.right = right;
	}
	
	public void add(Integer value) {
	    if (value < this.value) {
	        if (left != null) {
	            left.add(value);
	        } else {
	            left = new NodeModel();
	            left.setValue(value);
	        }
	    } else if (value > this.value) {
	        if (right != null) {
	            right.add(value);
	        } else {
	            right = new NodeModel();
	            right.setValue(value);
	        }
	    }
	}
	
	public void printInOrder(){
		// Izq, padre, derecho
        if(left!=null){
            left.printInOrder();
        }
        System.out.println(value+",");
        if(right!=null){
            right.printInOrder();
        }
	}
    public void printPreOrder(){
    	//Padre, Izq, der
    	System.out.println(value+",");
        if(left!=null){
            left.printPreOrder();
        }
        if(right!=null){
            right.printPreOrder();
        }
    }
 
    public void printPosOrder(){
    	//Izq, Drecho, Padre
        if(left!=null){
            left.printPreOrder();
        }
        if(right!=null){
            right.printPreOrder();
        }
        System.out.println(value+",");
    }
    

}