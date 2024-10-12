package edu.hit.ninth.controller;

import edu.hit.ninth.pojo.Result;
import edu.hit.ninth.pojo.Sys_user;
import edu.hit.ninth.service.Sys_userService;
import edu.hit.ninth.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
public class LoginController {
    @Autowired
    private Sys_userService sys_userService;
    @PostMapping("/login")

    public Result login(@RequestBody Sys_user sys_user){
        Sys_user s=sys_userService.login(sys_user);
        if (s!=null){
            Map<String,Object> claims=new HashMap<>();
            claims.put("userName",s.getUserName());
//            claims.put("userIdentity",s.getUserIdentity());
            claims.put("userPassword",s.getUserPassword());
//            claims.put("userEmail",s.getUserEmail());

            String jwt= JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");

    }
}
