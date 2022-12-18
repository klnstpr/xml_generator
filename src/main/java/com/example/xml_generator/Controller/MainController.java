package com.example.xml_generator.Controller;

import com.example.xml_generator.WriteXMLFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController{

    @GetMapping("/index")
    private String HelloWorld() {
        return "index";
    }

    @GetMapping("/download/{numbers}")
    private String DownloadXMLFile(@PathVariable("numbers") Integer numbers) {
        WriteXMLFile writeXMLFile = new WriteXMLFile();
        if (numbers>0) {
            writeXMLFile.exportToXML(numbers);
            return "redirect:/success";
        }
        else return "redirect:/error";
    }

    @GetMapping("/success")
    private String DownloadXMLFileSuccess() {
        return "success";
    }

}
