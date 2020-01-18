package co.com.hfmd.bt.service;

import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.com.hfmd.model.NodeModel;

@Service
@Scope("prototype")
public class BinaryTreeService {
	
	private NodeModel binaryTree;
	
	@PostConstruct
	public void init() {
		try {
			System.out.println("Binary Tree init");
			//CreateBinaryTree();
		} catch (Exception e) {
			System.out.println("Binary Tree error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void CreateBinaryTree()
	{
		Random r = new Random();
		int newRaiz = r.nextInt(100)+1; 
		
		binaryTree = new NodeModel();
		binaryTree.setValue(newRaiz);
		
		for (int i=1; i<=20; i++)
		{
			int newValue = r.nextInt(100)+1; 
			binaryTree.add(newValue);
		}
	}
	
	public NodeModel getBinaryTree()
	{
		CreateBinaryTree();
		return this.binaryTree;
	}
	
	public void traceTree()
	{
		binaryTree.printInOrder();
	}
	
    public NodeModel findLCA(NodeModel node, int t1, int t2) {
        if(node == null) {
            return null;
        }
        if(node.getValue() > t2 && node.getValue() > t1) {
            // la busqueda de ambos decsienden a la Izq
            return findLCA(node.getLeft(), t1, t2);
        } else if (node.getValue() < t2 && node.getValue() < t1) {
            // la busqueda de ambos descienden a la derecha 
            return findLCA(node.getRight(), t1, t2);
        } else {
        	// la busqueda se bifurca, entonces ya encontramos al ancestro mas cercano
        	// haora hay que verificar si los nodeos existen
        	if ((findNode(node, t1) != null) && (findNode(node, t2) != null))
        	{
        		return node;
        	}
        	else
        	{
        		return null;
        	}
        }
    }
    
    public NodeModel findNode(NodeModel node, int t1)
    {
    	if(node == null) {
            return null;
        }
        if(node.getValue() > t1) {
              return findNode(node.getLeft(), t1 );
        } else if (node.getValue() < t1) {
             return findNode(node.getRight(), t1);
        } else {
        	return node;
        }
    }

}
