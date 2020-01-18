package co.com.hfmd.bt.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NodeDto {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("value")
    private Integer value;
	
	@JsonProperty("left")
    private NodeDto left;
	
	@JsonProperty("right")
    private NodeDto right;
 
  	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public NodeDto getLeft() {
		return left;
	}

	public void setLeft(NodeDto left) {
		this.left = left;
	}

	public NodeDto getRight() {
		return right;
	}

	public void setRight(NodeDto right) {
		this.right = right;
	}
	
}