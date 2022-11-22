package com.proyecto2.spring.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.proyecto2.spring.model.Videojuego;
/**
 * 
 * @author Martin
 *
 */
public class VideojuegoRepositoryImpl implements VideojuegoRepository{
	/**
	 * @author Martin
	 * Metodo para cargar los juegos del CSV
	 */
	@Override
	public List<Videojuego> cargaJuegos() {
		ArrayList<Videojuego> coleccionObtenida = new ArrayList<Videojuego>();
		
		try {
			FileReader filereader = new FileReader(new File("files/vgales.csv"));
			BufferedReader bufferedreader = new BufferedReader(filereader);
			bufferedreader.readLine(); // La primera linea son las cabeceras
			String line = bufferedreader.readLine();
			while( line != null) {
				String[] filaDelArchivoCSV = line.split(",");
				
				
				int id = Integer.parseInt(filaDelArchivoCSV[0]);
				String nombre = filaDelArchivoCSV[1];
				
				int lanzamiento = -1;
				try{
					lanzamiento = Integer.parseInt(filaDelArchivoCSV[3]);
				}catch(NumberFormatException ex) {
					lanzamiento = -1;
				}
				
				String genero = filaDelArchivoCSV[4];
				String plataforma = filaDelArchivoCSV[2];
				String editora = filaDelArchivoCSV[5];
				
				double ventasAmerica = -1;
				 try {
					 ventasAmerica = Double.parseDouble(filaDelArchivoCSV[6]);
				 }catch(NumberFormatException ex) {
					ventasAmerica = -1;
				}
				 double ventasEuropa=-1;
				 try {
					 ventasEuropa = Double.parseDouble(filaDelArchivoCSV[7]);
				 }catch(NumberFormatException ex) {
					ventasEuropa = -1;
				}
				 double ventasJapon=-1;
				 try {
					 ventasJapon = Double.parseDouble(filaDelArchivoCSV[8]);
				 }catch(NumberFormatException ex) {
					 ventasJapon = -1;
				}
				 double ventasOtros=-1;
				 try {
					 ventasOtros = Double.parseDouble(filaDelArchivoCSV[9]);
				 }catch(NumberFormatException ex) {
					 ventasOtros = -1;
				}
				
				Videojuego juego = new Videojuego( id,  nombre,  lanzamiento,  editora,  plataforma,  genero,
						 ventasAmerica,  ventasEuropa,  ventasJapon,  ventasOtros);
				coleccionObtenida.add(juego);
				
				line=bufferedreader.readLine();
			}
		} catch (FileNotFoundException ex) {
			//Logear error
		} catch (IOException ex){
			//Logear error
		}
		return coleccionObtenida;
	}

	@Override
	public List<Videojuego> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Videojuego> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Videojuego> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Videojuego> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Videojuego> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Videojuego> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Videojuego> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Videojuego getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Videojuego getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Videojuego getReferenceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Videojuego> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Videojuego> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Videojuego> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Videojuego> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Videojuego> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Videojuego entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Videojuego> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Videojuego> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Videojuego> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Videojuego> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Videojuego> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Videojuego, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
