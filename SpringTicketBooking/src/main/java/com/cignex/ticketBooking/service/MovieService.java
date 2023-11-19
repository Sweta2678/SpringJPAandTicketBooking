package com.cignex.ticketBooking.service;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cignex.ticketBooking.model.Movie;

import com.cignex.ticketBooking.repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;
//	private ResourceLoader resourceLoader;
//	private static String UPLOAD_ROOT = "upload_dir";

	@PersistenceContext
	EntityManager em;
	public List<Movie> getAllMovie() {
		return movieRepository.findAll();
	}

	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);

	}
	public void deleteMovie(int Id) {
		movieRepository.deleteById(Id);
	}

	public Optional<Movie> getById(int id) {
		return movieRepository.findById(id);
	}

	public void updateMovie(Movie movie) {
		movieRepository.save(movie);
	}
	
	public Path getpath(MultipartFile[] image) {
		Path path = null;
		  String pathh = null;
		  for (MultipartFile file2 : image) {
		   pathh = "E:\\eclipse_workspace\\SpringTicketBooking\\src\\main\\webapp\\WEB-INF\\jsp\\images\\" + file2.getOriginalFilename();
		   path = Paths.get(pathh);
		   try {
		    Files.write(path, file2.getBytes());
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		  }
		return path;
	}
	
//	public Optional<Movie> getImageById(int id) {
//		Query query = em.createQuery("select movie from Movie movie where movie.id="+id);
//		List<Movie> mvs = query.getResultList();
//
//		 Blob blob = ((Object) mvs).getBlob();
//         
//         InputStream inputStream = blob.getBinaryStream();
//         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//         byte[] buffer = new byte[4096];
//         int bytesRead = -1;
//	}
//	
//	public Resource getImage(String image) {
//		return resourceLoader.getResource("file:"+UPLOAD_ROOT+"/"+image);
//	}
//	
//	public void CreateImage(MultipartFile image) throws IOException {
//		if(!image.isEmpty()) {
//			Files.copy(image.getInputStream(), Paths.get(UPLOAD_ROOT, image.getOriginalFilename()));
//			movieRepository.save(new Movie(0, image.getOriginalFilename(), null, null, null, null));
//		}
//	}
//	
//	
//	@Value("${upload.path}")
//    private String path;
//
//    public String uploadFile(MultipartFile file) {
//
//        if (file.isEmpty()) {
//           System.out.println("upload image");
//        }
//
//        try {
//            String fileName = file.getOriginalFilename();
//            InputStream is = file.getInputStream();
//
//            Files.copy(is, Paths.get(path + fileName),
//                    StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//
//            String msg = String.format("Failed to store file", file.getName());
//
//           
//        }
//		return path;
//
//    }
}
