package com.MuhammadDev.jpa;

import com.MuhammadDev.jpa.models.Author;
import com.MuhammadDev.jpa.models.Text;
import com.MuhammadDev.jpa.models.Video;
import com.MuhammadDev.jpa.models.specification.AuthorSpecification;
import com.MuhammadDev.jpa.repositorise.AuthorRepository;
import com.MuhammadDev.jpa.repositorise.TextRepository;
import com.MuhammadDev.jpa.repositorise.VideoRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner (
			AuthorRepository authorRepository ,
			VideoRepository videoRepository,
			TextRepository textRepository){
		return args -> {
			Faker faker = new Faker();
		for(int i =0; i<50; i++){

			var author = Author.builder()
					.firstName(faker.name().firstName())
					.lastName(faker.name().lastName())
					.email(faker.name().username()+"@gmail.com")
					.age(faker.number().numberBetween(19,50))
					.createdAt(LocalDateTime.now())
					.build();
			//authorRepository.save(author);
		}

			var author = Author.builder()
					.id(1)
					.firstName("Muhammad")
					.lastName("Alaa")
					.email("muhammadalaa695@gmail.com")
					.age(21)
					.createdAt(LocalDateTime.now())
					.build();
		//	authorRepository.save(author);


//			authorRepository.updateAuthor(23,2);
//			authorRepository.updateAuthor(23,30);
//			authorRepository.updateAuthor(23,44);
//			//authorRepository.updateAllAuthorsAges(50);
//			//authorRepository.deleteById(100);

//			System.out.println( authorRepository.findByAgeLessThanOrEquals(44));




//			var video = Video.builder()
//					.name("Lecture one")
//					.size(40)
//					.url("https:nfnj")
//					.length(7.50)
//					.build();
//			videoRepository.save(video);
//			var text = Text.builder()
//					.name("lecture two")
//					.content("bla bla bla")
//					.build();
//			textRepository.save(text);


			Specification <Author> specification = Specification
					.where(AuthorSpecification.hasAge(50))
					.and(AuthorSpecification.firstnameLike("n"));
			authorRepository.findAll(specification).forEach(System.out::println);

		};
	}

}
