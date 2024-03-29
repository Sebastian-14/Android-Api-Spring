package pe.edu.tecsup.productosapi.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pe.edu.tecsup.productosapi.models.Producto;

@Repository
public class ProductoRepository {

	private static final Logger logger = LoggerFactory.getLogger(ProductoRepository.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Producto> listar() {
		logger.info("call listar()");
		
		String sql = "select * from productos";
		
		List<Producto> productos = jdbcTemplate.query(sql, new RowMapper<Producto>() {
			@Override
			public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setPrecio(rs.getDouble("precio"));
				if(rs.wasNull()) producto.setPrecio(null);
				producto.setImagen(rs.getString("imagen"));
				producto.setDetalles(rs.getString("detalles"));
				producto.setEstado(rs.getString("estado"));

				return producto;
			}
		});
		
		logger.info("productos: " + productos);
		
		return productos;
	}
	
}
