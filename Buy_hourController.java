package edu.hit.ninth.controller;


import edu.hit.ninth.pojo.PageBean;
import edu.hit.ninth.pojo.Result;
import edu.hit.ninth.service.Buy_hourService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class Buy_hourController {
    @Autowired
    private Buy_hourService buy_hourService;

    @GetMapping("/time")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "24") Integer pageSize,
                       Integer buy_times, Integer hour) {
        log.info("分页查询，参数:{},{},{},{}", page, pageSize, buy_times, hour);
        //调用service分页查询
        PageBean pageBean = buy_hourService.page(page, pageSize, buy_times, hour);
        return Result.success(pageBean);
    }
    @PostMapping("/time")
    public Result save(@RequestBody Buy_hour buy_hour){
        buy_hourService.save(buy_hour);
        return Result.success();
    }
    @GetMapping ("/time/{buy_times}")
    public Result getByBuy_times(@PathVariable Integer buy_times){
        Buy_hour buy_hour=buy_hourService.getByBuy_times(buy_times);
        return Result.success(buy_hour);
    }
    @PutMapping("/time")
    public Result update(@RequestBody Buy_hour buy_hour){
        buy_hourService.update(buy_hour);
        return Result.success();
    }

}