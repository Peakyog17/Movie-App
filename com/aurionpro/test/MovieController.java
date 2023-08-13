package com.aurionpro.test;

import java.util.List;
import java.util.Scanner;

import com.aurionpro.model.GenreType;
import com.aurionpro.model.Movie;
import com.aurionpro.model.MovieManager;

public class MovieController {
	private MovieManager manager;
	Scanner sc;

	public MovieController() {
		manager = new MovieManager();
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		MovieController controller = new MovieController();
		controller.start();

	}

	public void start() {
		displayMenu();
	}

	public void displayMenu() {
		int choice = 0;
		while (choice != 8) {
			System.out.println("WELCOME TO YOUR MOVIE MANAGER !");
			System.out.println("ENTER 1 TO ADD MOVIE ! ");
			System.out.println("ENTER 2 TO GET LIST OF MOVIES !");
			System.out.println("ENTER 3 TO GET MOVIE BY ID !");
			System.out.println("ENTER 4 TO SAVE MOVIE !");
			System.out.println("ENTER 5 TO LOAD SAVED MOVIE");
			System.out.println("ENTER 6 TO DELETE A MOVIE");
			System.out.println("ENTER 7 TO CLEAR ALL THE MOVIES ");
			System.out.println("ENTER 8 EXIT !");
			System.out.println("PLEASE ENTER YOUR CHOICE !");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				addMovie();
				break;
			case 2:
				getMoviesList();
				break;
			case 3:
				getMovieByID();
				break;
			case 4:
				saveMovies();
				break;
			case 5:
				loadMovies();
				break;
			case 6:
				deleteMovie();
				break;
			case 7:
				clearMovies();
				break;
			case 8:
				System.out.println("Thank you for using the movie app :) ");
				System.out.println("-----------------------");
				break;
			default:
				System.out.println("Invalid input entered !");
				System.out.println("-----------------------");
				break;
			}
		}
	}

	private void deleteMovie() {
		System.out.println("Enter id of the movie you wish to delete:");
		int id = sc.nextInt();
		sc.nextLine();

		Movie movie = manager.deleteMovie(id);
		if (movie != null) {
			System.out.println(movie + " was chosen to be deleted ");
			System.out.println("Movie has been deleted...");
			System.out.println("-----------------------");
		}
		System.out.println(movie);
		System.out.println("-----------------------");
	}

	private void addMovie() {
		System.out.println("PLEASE ENTER MOVIE DETAILS");
		System.out.println("-----------------------");
		System.out.println("Enter movie ID : ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("-----------------------");
		System.out.println("Enter movie name : ");

		String name = sc.nextLine();
		System.out.println("-----------------------");
		System.out.println("Enter movie year : ");
		int year = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter movie genre from (SCI_FI,ROMANCE,ACTION,COMEDY,FEEL_GOOD): ");
		String movieGenre = sc.nextLine();
		try {
			GenreType genre = GenreType.valueOf(movieGenre.toUpperCase());
			Movie movie = new Movie(id, name, year, genre);

			manager.addMovie(movie);
			System.out.println("Movie added succesfully !");
			System.out.println("-----------------------");
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid genre input");
			System.out.println("-----------------------");
		}
	}

	public void getMoviesList() {
		List<Movie> movies = manager.getMovies();
		System.out.println("---->HERE'S THE LIST OF MOVIES ...<----");
		for (Movie movie : movies) {
			System.out.println(movie);
			System.out.println("-----------------------");
		}
		System.out.println("------------------------");
	}

	public void getMovieByID() {
		System.out.println("Enter movie ID");
		int id = sc.nextInt();
		sc.nextLine();

		Movie movie = manager.getMovieById(id);
		if (movie != null) {
			System.out.println("The details are as follows :");
			System.out.println(movie);
			System.out.println("--------------------------------");
		} else {
			System.out.println("Movie not found ....");
			System.out.println("-----------------------------------");
		}

	}

	public void saveMovies() {
		manager.saveMovies();
		System.out.println("-------------------------");
	}

	public void loadMovies() {
		manager.loadMovies();
		System.out.println("---------------------------");
	}

	public void clearMovies() {
		manager.clearMovies();
		System.out.println("----------------------------");
	}

}
