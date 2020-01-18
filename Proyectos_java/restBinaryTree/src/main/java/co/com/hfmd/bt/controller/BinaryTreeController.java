package co.com.hfmd.bt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.hfmd.bt.service.BinaryTreeService;
import co.com.hfmd.model.NodeModel;

import co.com.hfmd.bt.dto.NodeDto;


@Controller
@CrossOrigin
@RequestMapping("management/tree")
public class BinaryTreeController {
	
	@Autowired
	private BinaryTreeService binaryTreeService;
	
	@RequestMapping(value = "/binarytree", method = RequestMethod.GET)
	public ResponseEntity<?> getTree() {

		
		try {

			return new ResponseEntity<>(binaryTreeService.getBinaryTree(), HttpStatus.OK);

		
		} catch (Exception excepcion) {

			return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
	@RequestMapping(value = "/binarytree/Ancestor", method = RequestMethod.GET)
	public ResponseEntity<?> getAncesgtor(@RequestBody NodeDto pNode,
											@RequestParam(name = "pNodeOne") Integer pNodeOne,
											@RequestParam(name = "pNodeTwo") Integer pNodeTwo) {

		ObjectMapper mapper = new ObjectMapper();
		String stringJSON = "";
		
		try {
			stringJSON = mapper.writeValueAsString(pNode);
			NodeModel buscar = mapper.readValue(stringJSON,NodeModel.class);
			NodeModel respuesta = binaryTreeService.findLCA(buscar, pNodeOne,  pNodeTwo) ;
			String ancestro = (respuesta != null )? respuesta.getValue().toString(): "Sin Ancestro ";
			String response = "LowestCommonAncestor(tree, "+pNodeOne+", "+pNodeTwo+") = "+ancestro ;
			return new ResponseEntity<>(response, HttpStatus.OK);

		
		} catch (Exception excepcion) {

			return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}


}
