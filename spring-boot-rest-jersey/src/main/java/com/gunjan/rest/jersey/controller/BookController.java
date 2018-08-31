package com.gunjan.rest.jersey.controller;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.gunjan.rest.jersey.model.Book;
import com.gunjan.rest.jersey.service.BookService;
import org.springframework.stereotype.Component;

@Component
@Path("/books")
public class BookController {
	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GET
	@Produces("application/json")
	public Collection<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GET
	@Produces("application/json")
	@Path("/{oid}")
	public Book getBook(@PathParam("oid") String oid) {
		return bookService.getBook(oid);
	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response addBook(Book book) {
		bookService.addBook(book);
		return Response.created(URI.create("/" + book.getOid())).build();
	}

	@PUT
	@Consumes("application/json")
	@Path("/{oid}")
	public Response updateBook(@PathParam("oid") String oid, Book book) {
		bookService.updateBook(oid, book);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{oid}")
	public Response deleteBook(@PathParam("oid") String oid) {
		bookService.deleteBook(oid);
		return Response.ok().build();
	}
}
