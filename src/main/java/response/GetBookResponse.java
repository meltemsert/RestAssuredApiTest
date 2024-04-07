package response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class GetBookResponse {
	public BooksItem book;
}