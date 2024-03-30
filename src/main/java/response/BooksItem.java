package response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data
public class BooksItem{
	public String website;
	public Integer pages;
	public String subTitle;
	public String author;
	public String isbn;
	public String publisher;
	public String description;
	public String title;
	public String publishDate;
}