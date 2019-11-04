package kokhanevych.spring.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookDto {
    @NotNull
    @NotEmpty
    private String title;
    @NotNull
    private Double price;
    @NotNull
    private Integer year;
}
