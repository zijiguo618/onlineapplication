package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;

@Controller
public class UploadController {

	//Save the uploaded file to this folder, the foler has to be created
    private static String UPLOADED_FOLDER = "upload-dir//";

    @PostMapping("/uploadMulti")
    public String multiFileUpload(@RequestParam("files") MultipartFile[] files,@RequestParam("businessfile") MultipartFile busfile,
    		@RequestParam("issuedid") MultipartFile issuedid,@RequestParam("voidedcheck") MultipartFile voidedcheck,@RequestParam("bankstatement") MultipartFile bankstatement,
                                  RedirectAttributes redirectAttributes) {

        StringJoiner sj = new StringJoiner(" , ");
        if (busfile.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please upload your Business license");
            return "redirect:/uploadMulti";
        }
        else if (issuedid.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please upload your issued ID");
            return "redirect:/uploadMulti";
        }
        else if (bankstatement.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please upload your Bank Statement");
            return "redirect:/uploadMulti";
        }

        try {

            // Get the file and save it somewhere
            byte[] busfilebytes = busfile.getBytes();
            byte[] issuedidbytes = issuedid.getBytes();
            byte[] voidedcheckbytes = voidedcheck.getBytes();
            byte[] bankstatementbytes = bankstatement.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + "bsi_"+busfile.getOriginalFilename());
            Files.write(path, busfilebytes);
            path =Paths.get(UPLOADED_FOLDER + "ID_"+issuedid.getOriginalFilename());
            Files.write(path, issuedidbytes);
            path =Paths.get(UPLOADED_FOLDER + "check_"+voidedcheck.getOriginalFilename());
            Files.write(path, voidedcheckbytes);
            path =Paths.get(UPLOADED_FOLDER + "bank_"+bankstatement.getOriginalFilename());
            Files.write(path, bankstatementbytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (MultipartFile file : files) {
        		System.out.println(file.getName());
        		
            if (file.isEmpty()) {
                continue; //next pls
            }

            try {

                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER +"store_"+ file.getOriginalFilename());
                Files.write(path, bytes);

                sj.add(file.getOriginalFilename());

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return "redirect:/uploadMulti";

    }

    @GetMapping("/uploadMulti")
    public String uploadMultiPage() {
        return "uploadMulti";
    }

}