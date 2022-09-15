package com.example.backend.Controller;

import com.example.backend.PO.Paper;
import com.example.backend.PO.Test;
import com.example.backend.Service.*;
import com.example.backend.Service.impl.PaperServiceImpl;
import com.example.backend.Service.impl.TestServiceImpl;
import com.example.backend.Vo.PaperCreateVo;
import com.example.backend.Vo.QuestionVo;
import com.example.backend.Vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/paper")
public class PaperController {

    @Autowired
    private TestServiceImpl testService;
    @Autowired
    private PaperServiceImpl paperService;
    @Autowired
    private PS ps;
    @Autowired
    private PaperReader paperReader;
    @Autowired
    private OB1 ob1;
    @Autowired
    private OB2 ob2;
    @Autowired
    private SQ sq;

    @GetMapping("/all")
    ResultVo<List<Paper>> getAllPaper(@RequestParam(required = false) Map map) {

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
            return new ResultVo<>(0, "获取试卷详情成功", paper);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "获取试卷详情失败", null);
        }
    }

    @GetMapping("/question/{paperid}")
    ResultVo<QuestionVo> showPaperQuestion(@PathVariable String paperid) {

        try {
            QuestionVo questionVo = paperReader.read2(paperService.getPaperDetail(paperid));
            return new ResultVo<>(0, "获取问题列表成功", questionVo);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "获取问题列表失败", null);
        }
    }

    @PostMapping("/update")
    ResultVo updatePaper(@RequestBody Paper paper) {

        try {
            paperService.updatePaper(paper);
            return new ResultVo<>(0, "修改试卷成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "修改试卷失败", null);
        }
    }

    @PostMapping("/create")
    ResultVo<PaperCreateVo> createPaper(@RequestParam Map map) {
        /*
         * 手动组卷 */
        try {
            System.out.println("create: " + map);

            ps.clearListAndStringBuilder();

            List<Long> questionList = new ArrayList<>();
            for (String question : map.get("value").toString().split(",")) {
                questionList.add(Long.parseLong(question));
            }

            switch (map.get("problem").toString()) {
                case "SingleChoice":
                    ps.showSelectedObjectiveQuestion1(questionList);
                    break;
                case "Judgement":
                    ps.showSelectedObjectiveQuestion2(questionList);
                    break;
                case "GAPFilling":
                    ps.showSelectedSubjectiveQuestion(questionList);
                    break;
            }

//            Map<String, List<Long>> map1 = new HashMap<>();
//            List<Long> list1 = new ArrayList<>();
//            List<Long> list2 = new ArrayList<>();
//            list1.add(1011L);
//            list1.add(1012L);
//            list2.add(1001L);
//            list2.add(1002L);
//            map1.put("ob1", list1);
//            map1.put("ob2", list2);
//            map1.put("sq", list2);
//            ps.showSelectedObjectiveQuestion1(map1.get("ob1"));
//            ps.showSelectedObjectiveQuestion2(map1.get("ob2"));
//            ps.showSelectedSubjectiveQuestion(map1.get("sq"));


            String coursename = map.get("subject").toString();
            Long questionteacher = 0L;
            if (map.containsKey("questionteacher")) {
                questionteacher = Long.parseLong(map.get("questionteacher").toString());
            }


            Long paperid = paperService.generatePaperId();

            Paper paper = ps.toPaper(paperid,
                    "",
                    coursename,
                    questionteacher);
            ps.savePaper(paper);


            String dateStr = map.get("date1").toString() + " " + map.get("date2").toString();
            int limitedtime = 60;
            if (map.containsKey("limitedtime")) {
                limitedtime = Integer.parseInt(map.get("limitedtime").toString());
            }
            Test test = new Test(0,
                    paperid,
                    coursename,
                    dateStr,
                    limitedtime,
                    questionteacher,
                    paperid,
                    questionteacher);
            test = testService.createTest(test);

            return new ResultVo<>(0, "手动组卷成功",
                    new PaperCreateVo(paper.getPaperid(), test.getTestid(), paper, test));

        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "手动组卷失败", null);
        }
    }

    @CrossOrigin
    @PostMapping("/generate")
    ResultVo<PaperCreateVo> generatePaper(@RequestParam Map map) {
        /*
         * 自动组卷 */

        try {
            System.out.println("generate: " + map);

            int num = Integer.parseInt(map.get("num").toString());

//            Map<String, String> map1 = new HashMap<>();
//            map1.put("Chinese", "语文");
//            map1.put("Math", "数学");
//            map1.put("Physics", "物理");
//            String coursename = map1.get(map.get("subject").toString());
            String coursename = map.get("subject").toString();

            ps.clearListAndStringBuilder();

            if (ob1.countAllQuestion(coursename) >= 4 && ob2.countAllQuestion(coursename) >= 4 &&
                    sq.countAllQuestion(coursename) >= 4) {
                ps.showSelectedObjectiveQuestion1(ob1.randomSelect(num / 3, coursename));
                num -= (num / 3);
                ps.showSelectedObjectiveQuestion2(ob2.randomSelect(num / 2, coursename));
                num -= (num / 2);
                ps.showSelectedSubjectiveQuestion(sq.randomSelect(num, coursename));
            } else {
                return new ResultVo<>(-1, "题库不足", null);
            }

            Long questionteacher = 0L;
            if (map.containsKey("questionteacher")) {
                 questionteacher = Long.parseLong(map.get("questionteacher").toString());
            }

            Long paperid = paperService.generatePaperId();

            Paper paper = ps.toPaper(paperid,
                    map.get("desc").toString(),
                    coursename,
                    questionteacher);
            ps.savePaper(paper);

            String dateStr = map.get("date1").toString() + " " + map.get("date2").toString();
            int limitedtime = 60;
            if (map.containsKey("limitedtime")) {
                limitedtime = Integer.parseInt(map.get("limitedtime").toString());
            }

            Test test = new Test(0,
                    paperid,
                    coursename,
                    dateStr,
                    limitedtime,
                    questionteacher,
                    paperid,
                    questionteacher);
            test = testService.createTest(test);

            return new ResultVo<>(0, "自动组卷成功",
                    new PaperCreateVo(paper.getPaperid(), test.getTestid(), paper, test));

        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVo<>(-1, "自动组卷失败", null);
        }
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
