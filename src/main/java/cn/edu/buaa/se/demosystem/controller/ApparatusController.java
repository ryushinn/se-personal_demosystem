package cn.edu.buaa.se.demosystem.controller;

import cn.edu.buaa.se.demosystem.bean.Apparatus;
import cn.edu.buaa.se.demosystem.service.ApparatusService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApparatusController {

    @Autowired
    private ApparatusService apparatusService;

    @GetMapping("/addApparatus")
    public String goAddPage() {
        return "addPage";
    }

    @PostMapping("/addApparatus")
    public String addApparatus(Apparatus apparatus, Model model) {
        apparatusService.insert(apparatus);
        model.addAttribute("message", "添加成功！设备号是:" + apparatus.getApparaId());
        return "addPage";
    }

    @GetMapping("/delete/{id}")
    public @ResponseBody String deleteApparatus(@PathVariable int id) {
        apparatusService.deleteByPrimaryKey(id);
        return "deleted OK!";
    }
    @GetMapping("/modifyApparatus/{id}")
    public String goModifyPage(@PathVariable int id, Model model) {
        model.addAttribute("me", apparatusService.findApparatusByPrimaryKey(id));
        return "modifyPage";
    }
    @PostMapping("/modifyApparatus")
    public String modifyApparatus(Apparatus apparatus, Model model) {
        apparatusService.updateApparatusByExample(apparatus);
        model.addAttribute("message", "修改成功！");
        model.addAttribute("me", apparatus);
        return "modifyPage";
    }

}
