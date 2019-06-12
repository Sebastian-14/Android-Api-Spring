package pe.edu.tecsup.productosapi.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.tecsup.productosapi.models.Producto;
import pe.edu.tecsup.productosapi.services.ProductoService;

@RestController
public class ProductoController {

	private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/productos")
	public List<Producto> productos(){
		logger.info("call productos()");
		
		List<Producto> productos = productoService.listar();
		logger.info("productos: " + productos);
		
		return productos;
	}
	
}
