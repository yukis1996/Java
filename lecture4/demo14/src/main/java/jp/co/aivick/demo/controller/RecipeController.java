package jp.co.aivick.demo.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import jp.co.aivick.demo.entity.Recipe;
import jp.co.aivick.demo.entity.User;
import jp.co.aivick.demo.service.RecipeService;
import jp.co.aivick.demo.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/recipes")
public class RecipeController
{
    final private RecipeService recipeService;

    final private UserService userService;

    public RecipeController(RecipeService recipeService, UserService userService) {
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @RequestMapping
    public String recipes(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByLoginId(userDetails.getUsername());
        model.addAttribute("recipeSet", recipeService.findAllWithLike(user.getId()));
        model.addAttribute("user", user);
        return "recipe.html";
    }

    @RequestMapping("/json")
    @ResponseBody
    @JsonSerialize
    public List<Recipe> recipes(Model model) {
        return recipeService.findAll().all();
    }

    @PostMapping("/like")
    @ResponseBody
    public Boolean like(@RequestParam Integer recipeId,
        @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByLoginId(userDetails.getUsername());
        recipeService.like(user.getId(), recipeId, true);
        return true;
    }

    @PostMapping("/unlike")
    @ResponseBody
    public Boolean unLike(@RequestParam Integer recipeId,
        @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByLoginId(userDetails.getUsername());
        recipeService.like(user.getId(), recipeId, false);
        return true;
    }
}
