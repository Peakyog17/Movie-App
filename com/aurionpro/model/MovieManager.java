package com.aurionpro.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MovieManager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Movie> movies;
	static final String filePath = "D:\\Serialize_files\\file.txt";

	public MovieManager() {
		movies = new ArrayList<>();
	}

	public void addMovie(Movie movie) {
		movies.add(movie);
	}

	public void clearMovies() {
		System.out.println("Movies have been cleared !");
		movies.clear();
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public Movie deleteMovie(int id) {
		for (Movie movie : movies) {
			if (id == movie.getId()) {
				return movie;
			}
		}
		return null;
	}

	public void saveMovies() {
		try {
			FileOutputStream file =new FileOutputStream("D:\\Serialize_files\\file.txt")	;
			ObjectOutputStream out=new ObjectOutputStream(file);
			out.writeObject(this.movies);
			out.close();
			file.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void loadMovies() {
		try {
			FileInputStream file=new FileInputStream("D:\\Serialize_files\\file.txt");
			ObjectInputStream in= new ObjectInputStream(file);
			this.movies=(List<Movie>)in.readObject();
			in.close();
			file.close();
		}
		catch(Exception e ) {
			e.printStackTrace();
		
		}
		
	}

	public Movie getMovieById(int id) {
		for (Movie movie : movies) {
			if (id == movie.getId()) {
				movies.remove(movie);
				return movie;
			}
		}
		return null;
	}

}
