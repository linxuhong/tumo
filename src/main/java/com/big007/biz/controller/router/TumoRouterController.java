package com.big007.biz.controller.router;

import com.big007.biz.entity.SysUser;
import com.big007.biz.service.ArticleService;
import com.big007.biz.service.CommentService;
import com.big007.biz.service.TagService;
import com.big007.biz.service.UserService;
import com.big007.common.controller.BaseController;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * 博客后台页面路由
 *
 * @author tycoding
 * @date 2020/6/27
 */
@ApiIgnore
@Controller
public class TumoRouterController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private TagService tagService;

    @Autowired
    private UserService userService;

    /**
     * 注销接口
     *
     * @return
     */
    @GetMapping(value = "/logout")
    public String logout() {
        Subject subject = getSubject();
        subject.logout();
        return "redirect:/login";
    }

    /**
     * 登录状态校验
     */
    private boolean auth(HttpServletRequest request, Model model) {
        Object o = request.getSession().getAttribute("user");
        model.addAttribute("user", o);
        return o instanceof SysUser;
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "login";
    }

    @GetMapping("/register")
    public String register(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "register";
    }

    @GetMapping("/tumo")
    public String index(HttpServletRequest request, Model model) {
        if (!this.auth(request, model)) {
            return "redirect:/login";
        }
        model.addAttribute("articleCount", articleService.count());
        model.addAttribute("tagCount", tagService.count());
        model.addAttribute("commentCount", commentService.count());
        model.addAttribute("userCount", userService.count());
        return "tumo/index/index";
    }

    @GetMapping("/tumo/profile")
    public String profile(HttpServletRequest request, Model model) {
        if (!this.auth(request, model)) {
            return "redirect:/login";
        }
        return "tumo/profile/index";
    }

    @GetMapping("/tumo/article/write")
    public String articleWrite(HttpServletRequest request, Model model) {
        if (!this.auth(request, model)) {
            return "redirect:/login";
        }
        return "tumo/article/write/index";
    }

    @GetMapping("/tumo/article/list")
    public String articleList(HttpServletRequest request, Model model) {
        if (!this.auth(request, model)) {
            return "redirect:/login";
        }
        return "tumo/article/list/index";
    }

    @GetMapping("/tumo/blog/tag")
    public String blogTag(HttpServletRequest request, Model model) {
        if (!this.auth(request, model)) {
            return "redirect:/login";
        }
        return "tumo/blog/tag/index";
    }

    @GetMapping("/tumo/blog/category")
    public String blogCategory(HttpServletRequest request, Model model) {
        if (!this.auth(request, model)) {
            return "redirect:/login";
        }
        return "tumo/blog/category/index";
    }

    @GetMapping("/tumo/blog/link")
    public String blogLink(HttpServletRequest request, Model model) {
        if (!this.auth(request, model)) {
            return "redirect:/login";
        }
        return "tumo/blog/link/index";
    }

    @GetMapping("/tumo/blog/comment")
    public String blogComment(HttpServletRequest request, Model model) {
        if (!this.auth(request, model)) {
            return "redirect:/login";
        }
        return "tumo/blog/comment/index";
    }

    @GetMapping("/tumo/setting/log")
    public String settingLog(HttpServletRequest request, Model model) {
        if (!this.auth(request, model)) {
            return "redirect:/login";
        }
        return "tumo/setting/log/index";
    }

    @GetMapping("/tumo/setting/qiniu")
    public String settingQiniu(HttpServletRequest request, Model model) {
        if (!this.auth(request, model)) {
            return "redirect:/login";
        }
        return "tumo/setting/qiniu/index";
    }

    @GetMapping("/tumo/setting/swagger")
    public String settingSwagger(HttpServletRequest request, Model model) {
        if (!this.auth(request, model)) {
            return "redirect:/login";
        }
        return "tumo/setting/swagger/index";
    }
}
