package response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class GetUserResponse {
	public BooksItem book;
}