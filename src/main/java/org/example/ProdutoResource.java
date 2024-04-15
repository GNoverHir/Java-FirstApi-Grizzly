package org.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("produtos")
public class ProdutoResource {
    private List<Produto> produtos = Arrays.asList(
            new Produto (1, "fone", 35),
            new Produto (2, "microfone", 200),
            new Produto (3, "monitor", 600)
    );
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> getProduto(){
        return produtos;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Produto getProduto(@PathParam("id") int id){
        return produtos.stream().filter(p -> p.getId() == id)
                .findFirst().orElse(null);
    }

}
