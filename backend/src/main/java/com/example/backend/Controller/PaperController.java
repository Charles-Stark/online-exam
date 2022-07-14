package com.example.backend.Controller;

import com.example.backend.PO.Paper;
import com.example.backend.Service.impl.PaperServiceImpl;
import com.example.backend.Vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/paper")
public class PaperController {

    @Autowired
    private PaperServiceImpl paperService;

    @GetMapping("/all")
    ResultVo<List<Paper>> getAllPaper(@RequestParam(required = false)Map map) {

        try {
            List paperList;
            if (map != null) {
                paperList = paperService.getAllPaper(map);
            } else {
                paperList = paperService.getAllPaper(null);
            }

            return new ResultVo<>(0, "获取试卷成功", paperList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "获取试卷失败", null);
        }
    }

    @GetMapping("/detail/{paperid}")
    ResultVo<Paper> getPaperDetail(@PathVariable String paperid) {

        try {
            Paper paper = paperService.getPaperDetail(paperid);
            return new ResultVo<>(0, "获取考试详情成功", paper);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "获取考试详情失败", null);
        }
    }

    @PostMapping("/update")
    ResultVo updatePaper(@RequestBody Paper paper) {

        try {
            paperService.updatePaper(paper);
            return new ResultVo<>(0, "修改试卷成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "修改考试失败", null);
        }
    }

    @PostMapping("/create")
    ResultVo<Paper> createPaper() {
        /* 未完成
        * 手动组卷 */
        return null;
    }

    @PostMapping("/generate")
    ResultVo<Paper> generatePaper() {
        /* 未完成
        * 自动组卷 */
        return null;
    }

    @GetMapping("/delete/{paperid}")
    ResultVo deletePaper(@PathVariable String paperid) {

        try {
            paperService.deletePaper(paperid);
            return new ResultVo<>(0, "删除试卷成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "删除试卷失败", null);
        }
    }
}
