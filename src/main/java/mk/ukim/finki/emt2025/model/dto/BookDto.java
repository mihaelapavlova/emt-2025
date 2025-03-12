package mk.ukim.finki.emt2025.model.dto;

import lombok.Data;
import mk.ukim.finki.emt2025.model.Author;
import mk.ukim.finki.emt2025.model.Category;

@Data
public class BookDto {
    private String name;
    private Long authorId;
    private Category category;
    private Integer availableCopies;
    public BookDto(){}
    public BookDto(String name, Long authorId, Category category, Integer avaiableCopies) {
        this.name = name;
        this.authorId = authorId;
        this.category = category;
        this.availableCopies = availableCopies;
    }

}
