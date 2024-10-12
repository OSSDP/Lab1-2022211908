package edu.hit.ninth.controller;

import edu.hit.ninth.pojo.PageBean;
import edu.hit.ninth.pojo.Result;
import edu.hit.ninth.pojo.Sys_user;
import edu.hit.ninth.service.Sys_userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
public class Sys_userController {
    @Autowired
    private Sys_userService sys_userService;

    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String userName, String userEmail) {
        log.info("分页查询，参数:{},{},{},{}", page, pageSize, userName, userEmail);
        //调用service分页查询
        PageBean pageBean = sys_userService.page(page, pageSize, userName, userEmail);
        return Result.success(pageBean);
    }
    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        sys_userService.delete(ids);
        return Result.success();

    }
    @PostMapping("/emps")
    public Result save(@RequestBody Sys_user sys_user){
        sys_userService.save(sys_user);
        return Result.success();
    }
    @GetMapping ("/emps/{id}")
    public Result getById(@PathVariable Integer id){
        Sys_user sys_user=sys_userService.getById(id);
        return Result.success(sys_user);
    }
    @PutMapping("/emps")
    public Result update(@RequestBody Sys_user sys_user){
        sys_userService.update(sys_user);
        return Result.success();
    }

}