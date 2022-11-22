package com.proyecto2.spring.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

}
