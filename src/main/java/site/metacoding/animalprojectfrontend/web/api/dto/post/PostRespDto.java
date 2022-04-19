package site.metacoding.animalprojectfrontend.web.api.dto.post;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.post.Post;
import site.metacoding.animalprojectfrontend.domain.user.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostRespDto {
    private Integer id;
    private String board;
    private String content;
    private LocalDateTime createDate;
    private String region;
    private String title;
    private String type;
    private String category;
    private User userId;

    public Post toEntity(User user) {
        Post post = new Post();
        post.setId(id);
        post.setBoard(board);
        post.setContent(content);
        post.setCreateDate(createDate);
        post.setRegion(region);
        post.setTitle(title);
        post.setType(type);
        post.setCategory(category);
        post.setUser(user);
        return post;
    }
}
