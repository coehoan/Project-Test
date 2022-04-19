package site.metacoding.animalprojectfrontend.web.api;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.post.Post;
import site.metacoding.animalprojectfrontend.domain.user.User;
import site.metacoding.animalprojectfrontend.service.PostService;
import site.metacoding.animalprojectfrontend.web.api.dto.ResponseDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.PostRespDto;
import site.metacoding.animalprojectfrontend.web.api.dto.post.WriteDto;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;
    private final HttpSession session;

    @PostMapping("/s/blog/write")
    public ResponseDto<?> write(@RequestBody WriteDto writeDto) {

        User principal = (User) session.getAttribute("principal");
        Post post = writeDto.toEntity(principal);

        postService.글쓰기(post);
        return new ResponseDto<>(1, "성공", null);
    }

    @GetMapping("/post/adopt")
    public ResponseDto<?> adopt(Model model) {
        // SELECT * FROM post WHERE board = "adopt"
        String board = "adopt";

        List<Post> posts = postService.글목록보기(board);

        // System.out.println("입양 컨트롤러22222222" + posts);

        // System.out.println("인덱스" + posts.get(0).getUser().getUsername());

        model.addAttribute("posts", posts);
        return new ResponseDto<>(1, "성공", null);
    }

    @GetMapping("/post/region")
    public ResponseDto<?> region() {
        // SELECT * FROM post WHERE board = "adopt"
        System.out.println("지역 컨트롤러");
        return new ResponseDto<>(1, "성공", null);
    }

    @GetMapping("/post/free")
    public ResponseDto<?> free() {
        // SELECT * FROM post WHERE board = "adopt"
        System.out.println("자유 컨트롤러");
        return new ResponseDto<>(1, "성공", null);
    }
}
